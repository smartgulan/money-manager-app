package com.example.money.controller;

import com.example.money.model.CategorySummary;
import com.example.money.repository.CategorySummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorySummaries")
public class CategoryController {

    @Autowired
    CategorySummaryRepository categoryRepository;

    @PostMapping
    public CategorySummary saveCategorySummary(@RequestBody CategorySummary categorySummary) {
        return categoryRepository.save(categorySummary);
    }

}
