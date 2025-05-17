package com.example.money.controller;

import com.example.money.model.Budget;
import com.example.money.repository.BudgetRepository;
import com.example.money.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    BudgetService budgetService;

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetRepository.save(budget);
    }

}
