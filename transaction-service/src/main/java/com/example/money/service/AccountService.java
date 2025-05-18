package com.example.money.service;

import com.example.common.dto.ErrorMessage;
import com.example.money.dto.AccountDto;
import com.example.money.model.Account;
import com.example.money.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Date;

@Service
public class AccountService {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<?> createAccount(Account account) {
        Account accountExitsts = accountRepository.findByUserEmail(tokenService.getEmail());
        if (accountExitsts != null) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Account with this email already exists", "error", new Date()));
        }
        accountRepository.save(account);
        return ResponseEntity.ok().body(account);
    }

    public ResponseEntity<?> deleteAccount(String email) {
        Account account = accountRepository.findByUserEmail(email);
        if (account == null) {
            return ResponseEntity.badRequest().body(new ErrorMessage("No account found", "error", new Date()));
        }
        accountRepository.delete(account);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> replenish(AccountDto accountDto) {
        try {
            Account account = accountRepository.findByUserEmail(accountDto.getReplenisherEmail());
            account.setBalance(account.getBalance().add(accountDto.getAmount()));
            accountRepository.save(account);
            return ResponseEntity.accepted().body(account);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ErrorMessage("Error replenishing account", "error", new Date()));
        }
    }

    public ResponseEntity<?> withdraw(AccountDto accountDto) {
        Account account = accountRepository.findByUserEmailAndName(accountDto.getWithdrawalEmail(), accountDto.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        if (account.getBalance().compareTo(accountDto.getAmount()) < 0) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Not enough balance", "error", new Date()));
        }
        account.setBalance(account.getBalance().subtract(accountDto.getAmount()));
        accountRepository.save(account);
        return ResponseEntity.ok().body(account);
    }

}
