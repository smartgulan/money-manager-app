package com.example.money.controller;

import com.example.money.model.Budget;
import com.example.money.repository.BudgetRepository;
import com.example.money.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<?> test() {
        return budgetService.budget();
    }

}
