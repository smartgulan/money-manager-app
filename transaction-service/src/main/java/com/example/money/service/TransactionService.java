package com.example.money.service;

import com.example.common.dto.ErrorMessage;
import com.example.money.dto.AccountDto;
import com.example.money.dto.TransactionDto;
import com.example.money.enums.TransactionType;
import com.example.money.model.Category;
import com.example.money.model.Expense;
import com.example.money.model.Transaction;
import com.example.money.repository.AccountRepository;
import com.example.money.repository.CategoryRepository;
import com.example.money.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<?> createTransaction(TransactionDto transactionDto, String token) {
        try {
            Transaction transaction = new Transaction();
            transaction.setNote(transactionDto.getNote());
            transaction.setType(TransactionType.findTransactionType(transactionDto.getType()).getValue());
            transaction.setAmount(transactionDto.getAmount());
            if (transaction.getType() == TransactionType.EXPENSE.getValue() || transaction.getType() == TransactionType.TRANSFER.getValue()) {
                Expense expense = new Expense();
                Category category = categoryRepository.findByName("expenses");
                expense.setNote(transaction.getNote());
                expense.setAmount(transaction.getAmount());
                expense.setCategory(category);
                expenseService.createExpense(expense, token);

                AccountDto fromAccount = accountRepository.findByUserEmail(transactionDto.getFromAccountEmail()).toAccountDto();
                fromAccount.setWithdrawalEmail(transactionDto.getFromAccountEmail());
                fromAccount.setAmount(transactionDto.getAmount());
                ResponseEntity<?> withdrawResult = accountService.withdraw(fromAccount);
                if (withdrawResult.getStatusCode() != HttpStatus.OK) {
                    return withdrawResult;
                }

                AccountDto toAccount = accountRepository.findByUserEmail(transactionDto.getToAccountEmail()).toAccountDto();
                toAccount.setAmount(transactionDto.getAmount());
                toAccount.setReplenisherEmail(transactionDto.getToAccountEmail());
                accountService.replenish(toAccount);
            }
            Transaction trans = transactionRepository.save(transaction);
            return ResponseEntity.ok().body(trans);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorMessage("Error creating transaction", "error", new Date()));
        }
    }

}
