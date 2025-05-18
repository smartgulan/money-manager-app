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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

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

    public ResponseEntity<?> createTransaction(TransactionDto transactionDto) {
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
                expenseService.createExpense(expense);

                AccountDto fromAccount = accountRepository.findByUserEmail(transactionDto.getFromAccount()).toAccountDto();
                fromAccount.setWithdrawalAmount(transactionDto.getAmount());
                accountService.withdraw(fromAccount);

                AccountDto toAccount = accountRepository.findByUserEmail(transactionDto.getToAccount()).toAccountDto();
                toAccount.setAmount(transactionDto.getAmount());
                accountService.replenish(toAccount);
            }
            Transaction trans = transactionRepository.save(transaction);
            return ResponseEntity.ok().body(trans);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorMessage("Error creating transaction", "error", new Date()));
        }
    }

}
