package com.example.money.model;

import com.example.money.model.core.UserEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Month;

@Entity
@Table(name = "monthly_summaries")
public class MonthlySummary extends UserEntity {

    @Column
    private Month month;

    @Column
    private double totalExpenses;

    @Column
    private double savings;

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

}
