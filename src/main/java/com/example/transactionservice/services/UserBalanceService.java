package com.example.transactionservice.services;

import com.example.transactionservice.entities.UserBalance;
import com.example.transactionservice.repositories.UserBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserBalanceService {
    private final UserBalanceRepository userBalanceRepository;

    public Double getBalance(Long userId) {
        return userBalanceRepository.findById(userId).get().getBalance();
    }

    public Double addBalance(Long userId, Double amount) {
        UserBalance userBalance = userBalanceRepository.findById(userId).orElse(null);

        if (userBalance == null) {
            userBalance = new UserBalance();
            userBalance.setUserId(userId);
            userBalance.setBalance(0.0);
        }

        userBalance.setBalance(userBalance.getBalance() + amount);
        userBalanceRepository.save(userBalance);
        return userBalance.getBalance();
    }

}