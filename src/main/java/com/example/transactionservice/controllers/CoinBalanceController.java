package com.example.transactionservice.controllers;

import com.example.transactionservice.DTOS.BuySellRequestDTO;
import com.example.transactionservice.entities.CryptocurrencyBalance;
import com.example.transactionservice.services.CryptocurrencyBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CoinBalanceController {
    private final CryptocurrencyBalanceService cryptoService;

    @PostMapping("/buy")
    public ResponseEntity<CryptocurrencyBalance> buyCrypto(@RequestBody BuySellRequestDTO request) {
        CryptocurrencyBalance updatedBalance = cryptoService.buy(request);
        return new ResponseEntity<>(updatedBalance, HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<CryptocurrencyBalance> sellCrypto(@RequestBody BuySellRequestDTO request) {
        CryptocurrencyBalance updatedBalance = cryptoService.sell(request);
        return new ResponseEntity<>(updatedBalance, HttpStatus.OK);
    }
}
