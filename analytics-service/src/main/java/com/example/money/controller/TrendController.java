package com.example.money.controller;

import com.example.money.model.TrendInsight;
import com.example.money.repository.TrendInsightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trends")
public class TrendController {

    @Autowired
    private TrendInsightRepository trendInsightRepository;

    @PostMapping
    public TrendInsight create(@RequestBody TrendInsight trendInsight) {
        return trendInsightRepository.save(trendInsight);
    }

}
