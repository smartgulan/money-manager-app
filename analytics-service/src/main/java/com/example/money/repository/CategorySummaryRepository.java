package com.example.money.repository;

import com.example.money.model.CategorySummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorySummaryRepository extends JpaRepository<CategorySummary, Long> {
}
