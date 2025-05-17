package com.example.money.controller;

import com.example.money.model.Category;
import com.example.money.model.Expense;
import com.example.money.repository.ExpenseRepository;
import com.example.money.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @GetMapping("/findAllByCategory")
    public List<Expense> findAllByCategory(@RequestParam String categoryName) {
        return expenseService.findAllByCategory(categoryName);
    }

}
