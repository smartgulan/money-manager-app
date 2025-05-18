package com.example.money.service;

import com.example.money.dto.CategoryExpenseDto;
import com.example.money.model.Category;
import com.example.money.model.Expense;
import com.example.money.repository.CategoryRepository;
import com.example.money.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.common.service.RestTemplateService;

import java.time.Month;
import java.util.List;

@Service
public class ExpenseService {

    @Value("${analytics.api.url}")
    private String analyticsApiUrl;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RestTemplateService restTemplateService;

    public void createExpense(Expense expense, String token) {
        CategoryExpenseDto body = new CategoryExpenseDto();
        body.setMonth(Month.MAY);
        body.setTotalSpent(expense.getAmount());
        restTemplateService.send(
                analyticsApiUrl + "/categorySummaries",
                token,
                body.getClass(),
                CategoryExpenseDto.class
        );
        expenseRepository.save(expense);
    }

    public List<Expense> findAllByCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return expenseRepository.findAllByCategory(category);
    }

}
