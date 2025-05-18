package com.example.money.dto;

import java.math.BigDecimal;

public class TransactionDto {

    private String type;
    private BigDecimal amount;
    private String note;
    private String fromAccountEmail;
    private String toAccountEmail;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getFromAccountEmail() {
        return fromAccountEmail;
    }

    public void setFromAccountEmail(String fromAccountEmail) {
        this.fromAccountEmail = fromAccountEmail;
    }

    public String getToAccountEmail() {
        return toAccountEmail;
    }

    public void setToAccountEmail(String toAccountEmail) {
        this.toAccountEmail = toAccountEmail;
    }

}
