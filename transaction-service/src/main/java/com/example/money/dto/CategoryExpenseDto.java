package com.example.money.dto;

import java.time.Month;

public class CategoryExpenseDto {

    private Month month;
    private double totalSpent;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

}
