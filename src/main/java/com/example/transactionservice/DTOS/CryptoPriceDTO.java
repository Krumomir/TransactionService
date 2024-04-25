package com.example.transactionservice.DTOS;

import lombok.Data;

@Data
public class CryptoPriceDTO {
    private Long id;
    private String name;
    private Double price;
}