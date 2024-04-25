package com.example.transactionservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class UserBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String userEmailAddress;
    private String currencyType;
    private Double balance;

}
