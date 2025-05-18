package com.example.money.model;

import com.example.money.model.core.UserEntity;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "expenses")
public class Expense extends UserEntity {

    @Column
    private BigDecimal amount;

    @Column
    private String note;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
