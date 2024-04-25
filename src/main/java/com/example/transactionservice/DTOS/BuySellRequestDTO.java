package com.example.transactionservice.DTOS;

import lombok.Data;

@Data
public class BuySellRequestDTO {
    private Long userId;
    private Long coinId;
    private String userEmailAddress;
    private Double amount;
}
