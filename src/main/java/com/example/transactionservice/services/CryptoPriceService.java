package com.example.transactionservice.services;

import com.example.transactionservice.entities.CryptoPrice;
import com.example.transactionservice.repositories.CryptoPriceRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CryptoPriceService {
    private final CryptoPriceRepository priceRepository;

    public CryptoPrice getPrice(Long id) {
        return priceRepository.findById(id).orElse(null);
    }

    public CryptoPrice updatePrice(CryptoPrice price) {
        return priceRepository.save(price);
    }
}
