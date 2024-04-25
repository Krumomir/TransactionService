package com.example.transactionservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class CryptoPrice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;

}
