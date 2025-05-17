package com.example.money.service;

import com.example.money.model.Category;
import com.example.money.model.Expense;
import com.example.money.repository.CategoryRepository;
import com.example.money.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> findAllByCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return expenseRepository.findAllByCategory(category);
    }

}
