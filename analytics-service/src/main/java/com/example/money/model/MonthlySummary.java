package com.example.money.model;

import com.example.money.model.core.UserEntity;

import javax.persistence.Column;
import java.time.Month;

public class MonthlySummary extends UserEntity {

    @Column
    private Month month;

    @Column
    private double totalExpenses;

    @Column
    private double savings;

}
