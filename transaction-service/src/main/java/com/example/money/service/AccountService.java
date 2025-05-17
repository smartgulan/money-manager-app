package com.example.money.service;

import com.example.money.model.Account;
import com.example.money.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TokenService tokenService;

    public Account createAccount(Account account) {
        Account accountExitsts = accountRepository.findByUserEmail(tokenService.getEmail());
        if (accountExitsts != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account already exists");
        }
        return accountRepository.save(account);
    }

    public ResponseEntity<?> deleteAccount(String email) {
        Account account = accountRepository.findByUserEmail(email);
        if (account == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        accountRepository.delete(account);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
