package com.example.transactionservice.services;

import com.example.transactionservice.DTOS.BuySellRequestDTO;
import com.example.transactionservice.entities.CryptoPrice;
import com.example.transactionservice.entities.CryptocurrencyBalance;
import com.example.transactionservice.entities.UserBalance;
import com.example.transactionservice.repositories.CryptoPriceRepository;
import com.example.transactionservice.repositories.CryptocurrencyBalanceRepository;
import com.example.transactionservice.repositories.UserBalanceRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CryptocurrencyBalanceService {
    private final CryptocurrencyBalanceRepository cryptoBalanceRepository;
    private final UserBalanceRepository currencyBalanceRepository;
    private final CryptoPriceRepository cryptoPriceRepository;
    private final KafkaTemplate<String, BuySellRequestDTO> kafkaTemplate;

    public CryptocurrencyBalance buy(BuySellRequestDTO requestDTO) {
        CryptoPrice coin = cryptoPriceRepository.findById(requestDTO.getCoinId()).orElse(null);
        CryptocurrencyBalance cryptoBalance = cryptoBalanceRepository.findByUserIdAndCoinId(requestDTO.getUserId(), coin);
        UserBalance currencyBalance = currencyBalanceRepository.findById(requestDTO.getUserId()).orElse(null);

        if (currencyBalance == null) {
            return null;
        }

        if (coin == null) {
            return null;
        }

        if (cryptoBalance == null) {
            cryptoBalance = new CryptocurrencyBalance();
            cryptoBalance.setUserId(requestDTO.getUserId());
            cryptoBalance.setCoinId(coin);
            cryptoBalance.setCoinBalance(0.0);
        }

        Double coinAmount = convertBetweenCurrency(currencyBalance.getCurrencyType(), requestDTO.getAmount());
        Double currencyAmount = dealPrice(coin, coinAmount, true);

        if (currencyBalance.getBalance() >= currencyAmount) {
            cryptoBalance.setCoinBalance(cryptoBalance.getCoinBalance() + coinAmount);
            currencyBalance.setBalance(currencyBalance.getBalance() - currencyAmount);
            kafkaTemplate.send("buy-topic", requestDTO);
            return cryptoBalanceRepository.save(cryptoBalance);
        }
        return null;
    }

    public CryptocurrencyBalance sell(BuySellRequestDTO requestDTO) {
        CryptoPrice coin = cryptoPriceRepository.findById(requestDTO.getCoinId()).orElse(null);
        CryptocurrencyBalance cryptoBalance = cryptoBalanceRepository.findByUserIdAndCoinId(requestDTO.getUserId(), coin);
        UserBalance currencyBalance = currencyBalanceRepository.findById(requestDTO.getUserId()).orElse(null);

        if (cryptoBalance == null || currencyBalance == null) {
            return null;
        }

        if (coin == null) {
            return null;
        }

        Double coinAmount = convertBetweenCurrency(currencyBalance.getCurrencyType(), requestDTO.getAmount());
        Double currencyAmount = dealPrice(coin, coinAmount, false);

        if (cryptoBalance.getCoinBalance() >= coinAmount) {
            cryptoBalance.setCoinBalance(cryptoBalance.getCoinBalance() - coinAmount);
            currencyBalance.setBalance(currencyBalance.getBalance() + currencyAmount);
            kafkaTemplate.send("sell-topic", requestDTO);
            return cryptoBalanceRepository.save(cryptoBalance);
        }

        return null;
    }

    public Double dealPrice(CryptoPrice coin, Double coinAmount, boolean isBuying) {
        if (coinAmount == null || coinAmount <= 0) {
            return null;
        }

        return coinAmount * coin.getPrice();
    }

    public Double convertBetweenCurrency(String currencyType, Double amount) {
        return switch (currencyType) {
            case "USD" -> amount;
            case "EUR" -> amount * 0.85;
            case "GBP" -> amount * 0.75;
            case "JPY" -> amount * 110.0;
            case "BGN" -> amount * 1.7;
            default -> null;
        };
    }

}
