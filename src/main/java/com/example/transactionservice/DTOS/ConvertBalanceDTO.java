package com.example.transactionservice.DTOS;

import lombok.Data;

@Data
public class ConvertBalanceDTO {
    private Long CoinId;
    private Double amount;
}
