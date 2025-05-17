package com.example.money.model;

import com.example.money.model.core.UserEntity;
import javax.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense extends UserEntity {

    @Column
    private double amount;

    @Column
    private String note;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
