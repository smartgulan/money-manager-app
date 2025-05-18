package com.example.money.repository;

import com.example.money.model.TrendInsight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendInsightRepository extends JpaRepository<TrendInsight, Long> {
}
