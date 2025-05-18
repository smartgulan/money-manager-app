package com.example.money.model;

import com.example.money.model.core.UserEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Month;

@Entity
@Table(name = "category_summaries")
public class CategorySummary extends UserEntity {

    @Column
    private Month month;

    @Column
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
