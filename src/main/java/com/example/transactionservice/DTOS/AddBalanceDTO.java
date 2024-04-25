package com.example.transactionservice.DTOS;

import lombok.Data;

@Data
public class AddBalanceDTO {
    private Long userId;
    private String currencyType;
    private String userEmailAddress;
    private Double amount;
}
