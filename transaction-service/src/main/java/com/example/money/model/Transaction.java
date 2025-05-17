package com.example.money.model;

import com.example.money.model.core.BaseEntity;
import com.example.money.model.core.CreateEntity;
import com.example.money.model.core.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction extends CreateEntity {

    @Column
    private String type;

    @Column
    private double amount;

    @Column
    private String note;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

}
