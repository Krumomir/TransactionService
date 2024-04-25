package com.example.transactionservice.repositories;

import com.example.transactionservice.entities.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBalanceRepository extends JpaRepository<UserBalance, Long> {
    UserBalance findByUserId(Long userId);
}
