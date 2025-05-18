package com.example.money.controller;

import com.example.money.dto.AccountDto;
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
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteAccount(@PathVariable String email) {
        return accountService.deleteAccount(email);
    }

    @PatchMapping("/replenish")
    public ResponseEntity<?> replenishAccount(@RequestBody AccountDto account) {
        return accountService.replenish(account);
    }

    @PatchMapping("/withdraw")
    public ResponseEntity<?> withdrawAccount(@RequestBody AccountDto account) {
        return accountService.withdraw(account);
    }

}
