package com.example.money.controller;

import com.example.money.model.MonthlySummary;
import com.example.money.repository.MonthlySummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monthlySummaries")
public class MonthlyController {

    @Autowired
    MonthlySummaryRepository monthlySummaryRepository;

    @PostMapping
    public MonthlySummary saveMonthlySummary(@RequestBody MonthlySummary monthSummary) {
        return monthlySummaryRepository.save(monthSummary);
    }

}
