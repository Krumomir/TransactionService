package com.example.transactionservice.DTOS;

import lombok.Data;

@Data
public class UserBalanceDTO {
    private Long id;
    private Long userId;
    private String currencyType;
    private Double balance;
}
