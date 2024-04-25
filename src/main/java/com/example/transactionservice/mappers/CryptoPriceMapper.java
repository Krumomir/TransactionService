package com.example.transactionservice.mappers;

import com.example.transactionservice.DTOS.CryptoPriceDTO;
import com.example.transactionservice.entities.CryptoPrice;
import org.springframework.stereotype.Component;

@Component
public class CryptoPriceMapper {
    public CryptoPriceDTO toDTO(CryptoPrice price) {
        CryptoPriceDTO dto = new CryptoPriceDTO();
        dto.setId(price.getId());
        dto.setName(price.getName());
        dto.setPrice(price.getPrice());
        return dto;
    }

    public CryptoPrice toEntity(CryptoPriceDTO dto) {
        CryptoPrice price = new CryptoPrice();
        price.setId(dto.getId());
        price.setName(dto.getName());
        price.setPrice(dto.getPrice());
        return price;
    }
}
