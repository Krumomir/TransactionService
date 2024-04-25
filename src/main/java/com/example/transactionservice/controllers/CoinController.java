package com.example.transactionservice.controllers;

import com.example.transactionservice.DTOS.CryptoPriceDTO;
import com.example.transactionservice.entities.CryptoPrice;
import com.example.transactionservice.services.CryptoPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CoinController {
    private final CryptoPriceService cryptoPriceService;

    //create coin
    @ PostMapping("/create")
    public CryptoPrice createCoin(@RequestBody CryptoPriceDTO cryptoPriceDTO) {
        return cryptoPriceService.createCoin(cryptoPriceDTO);
    }

}
