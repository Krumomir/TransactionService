package com.example.transactionservice.services;

import com.example.transactionservice.DTOS.AddBalanceDTO;
import com.example.transactionservice.entities.UserBalance;
import com.example.transactionservice.repositories.UserBalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserBalanceService {
    private final UserBalanceRepository userBalanceRepository;

    public Double getBalance(Long userId) {
        UserBalance userBalance = userBalanceRepository.findByUserId(userId);
        if (userBalance == null) {
            return 0.0;
        }
        return userBalance.getBalance();
    }

    public Double addBalance(AddBalanceDTO addBalanceDTO) {
        UserBalance userBalance = userBalanceRepository.findByUserId(addBalanceDTO.getUserId());

        if (userBalance == null) {
            userBalance = createUserBalance(addBalanceDTO);
        }

        userBalance.setBalance(userBalance.getBalance() + addBalanceDTO.getAmount());
        userBalanceRepository.save(userBalance);
        return userBalance.getBalance();
    }

    public UserBalance createUserBalance(AddBalanceDTO addBalanceDTO) {
        UserBalance userBalance = new UserBalance();
        userBalance.setUserId(addBalanceDTO.getUserId());
        userBalance.setUserEmailAddress(addBalanceDTO.getUserEmailAddress());
        userBalance.setCurrencyType(addBalanceDTO.getCurrencyType());
        userBalance.setBalance(0.0);
        return userBalanceRepository.save(userBalance);
    }

}