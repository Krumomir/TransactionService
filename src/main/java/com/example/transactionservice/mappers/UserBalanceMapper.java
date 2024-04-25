package com.example.transactionservice.mappers;

import com.example.transactionservice.DTOS.UserBalanceDTO;
import com.example.transactionservice.entities.UserBalance;
import org.springframework.stereotype.Component;

@Component
public class UserBalanceMapper {
    public UserBalanceDTO toDTO(UserBalance balance) {
        UserBalanceDTO dto = new UserBalanceDTO();
        dto.setId(balance.getId());
        dto.setUserId(balance.getUserId());
        dto.setCurrencyType(balance.getCurrencyType());
        dto.setBalance(balance.getBalance());
        return dto;
    }

    public UserBalance toEntity(UserBalanceDTO dto) {
        UserBalance balance = new UserBalance();
        balance.setId(dto.getId());
        balance.setUserId(dto.getUserId());
        balance.setCurrencyType(dto.getCurrencyType());
        balance.setBalance(dto.getBalance());
        return balance;
    }
}
