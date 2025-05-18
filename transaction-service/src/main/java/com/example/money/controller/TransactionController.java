package com.example.money.controller;

import com.example.money.dto.TransactionDto;
import com.example.money.model.Transaction;
import com.example.money.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transaction, @RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        return transactionService.createTransaction(transaction, jwt);
    }

}
