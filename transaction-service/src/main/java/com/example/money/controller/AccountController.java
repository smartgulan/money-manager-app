package com.example.money.controller;

import com.example.money.model.Account;
import com.example.money.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteAccount(@PathVariable String email) {
        return accountService.deleteAccount(email);
    }

}
