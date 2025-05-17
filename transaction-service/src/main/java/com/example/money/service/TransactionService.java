package com.example.money.service;

import com.example.money.dto.TransactionDto;
import com.example.money.enums.TransactionType;
import com.example.money.model.Category;
import com.example.money.model.Expense;
import com.example.money.model.Transaction;
import com.example.money.repository.CategoryRepository;
import com.example.money.repository.ExpenseRepository;
import com.example.money.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseService expenseService;

    public Transaction createTransaction(TransactionDto transactionDto) {
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
        }
        return transactionRepository.save(transaction);
    }

}
