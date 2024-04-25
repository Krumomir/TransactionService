package com.example.transactionservice.DTOS;

import lombok.Data;

import java.util.List;

@Data
public class CryptocurrencyBalanceDTO {
    private Long id;
    private Long userId;
    private List<Long> coinIds;
    private Double coinBalance;
}
