package com.example.money.controller;

import com.example.money.dto.TransactionDto;
import com.example.money.model.Transaction;
import com.example.money.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionDto transaction) {
        return transactionService.createTransaction(transaction);
    }

}
