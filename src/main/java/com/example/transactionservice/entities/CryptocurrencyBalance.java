package com.example.transactionservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CryptocurrencyBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "coinId")
    private CryptoPrice coinId;
    private Double coinBalance;
}
