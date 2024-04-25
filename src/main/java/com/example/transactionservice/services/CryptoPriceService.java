package com.example.transactionservice.services;

import com.example.transactionservice.DTOS.CryptoPriceDTO;
import com.example.transactionservice.entities.CryptoPrice;
import com.example.transactionservice.repositories.CryptoPriceRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CryptoPriceService {
    private final CryptoPriceRepository priceRepository;

    public CryptoPrice createCoin(CryptoPriceDTO cryptoPriceDTO) {
        CryptoPrice cryptoPrice = new CryptoPrice();
        cryptoPrice.setPrice(cryptoPriceDTO.getPrice());
        cryptoPrice.setName(cryptoPriceDTO.getName());
        return priceRepository.save(cryptoPrice);
    }
}
