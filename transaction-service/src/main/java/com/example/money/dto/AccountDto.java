package com.example.money.dto;

import java.math.BigDecimal;

public class AccountDto {

    private String name;
    private BigDecimal amount;
    private String withdrawalEmail;
    private String replenisherEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getWithdrawalEmail() {
        return withdrawalEmail;
    }

    public void setWithdrawalEmail(String withdrawalEmail) {
        this.withdrawalEmail = withdrawalEmail;
    }

    public String getReplenisherEmail() {
        return replenisherEmail;
    }

    public void setReplenisherEmail(String replenisherEmail) {
        this.replenisherEmail = replenisherEmail;
    }

}
