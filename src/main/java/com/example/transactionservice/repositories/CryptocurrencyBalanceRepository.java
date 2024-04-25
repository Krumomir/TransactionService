package com.example.transactionservice.repositories;

import com.example.transactionservice.entities.CryptoPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.transactionservice.entities.CryptocurrencyBalance;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyBalanceRepository extends JpaRepository<CryptocurrencyBalance, Long> {
    boolean existsByUserId(Long userId);
    CryptocurrencyBalance findByUserIdAndCoinId(Long userId, CryptoPrice coinId);
}
