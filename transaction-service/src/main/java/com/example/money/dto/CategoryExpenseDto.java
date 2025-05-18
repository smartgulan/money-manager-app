package com.example.money.dto;

import java.math.BigDecimal;
import java.time.Month;

public class CategoryExpenseDto {

    private Month month;
    private BigDecimal totalSpent;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(BigDecimal totalSpent) {
        this.totalSpent = totalSpent;
    }

}
