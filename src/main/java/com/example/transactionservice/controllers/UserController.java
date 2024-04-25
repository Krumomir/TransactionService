package com.example.transactionservice.controllers;

import com.example.transactionservice.DTOS.AddBalanceDTO;
import com.example.transactionservice.DTOS.ConvertBalanceDTO;
import com.example.transactionservice.services.UserBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserBalanceService userBalanceService;

    @PostMapping("/add/balance")
    public Double addBalance(@RequestBody AddBalanceDTO addBalanceDTO) {
        return userBalanceService.addBalance(addBalanceDTO.getUserId(), addBalanceDTO.getAmount());
    }

    @GetMapping("/balance/{userId}")
    public Double getBalance(@PathVariable Long userId) {
        return userBalanceService.getBalance(userId);
    }
}