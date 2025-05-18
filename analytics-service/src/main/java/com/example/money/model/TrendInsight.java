package com.example.money.model;

import com.example.money.model.core.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trend_insights")
public class TrendInsight extends UserEntity {

    @Column
    private String message;

}
