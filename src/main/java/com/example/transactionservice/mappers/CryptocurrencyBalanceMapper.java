package com.example.transactionservice.mappers;

import com.example.transactionservice.DTOS.CryptocurrencyBalanceDTO;
import com.example.transactionservice.entities.CryptocurrencyBalance;
import org.springframework.stereotype.Component;

@Component
public class CryptocurrencyBalanceMapper {
    public CryptocurrencyBalanceDTO toDTO(CryptocurrencyBalance balance) {
        CryptocurrencyBalanceDTO dto = new CryptocurrencyBalanceDTO();
        dto.setUserId(balance.getUserId());
        dto.setCoinBalance(balance.getCoinBalance());
        return dto;
    }

    public CryptocurrencyBalance toEntity(CryptocurrencyBalanceDTO dto) {
        CryptocurrencyBalance balance = new CryptocurrencyBalance();
        balance.setUserId(dto.getUserId());
        balance.setCoinBalance(dto.getCoinBalance());
        return balance;
    }
}
