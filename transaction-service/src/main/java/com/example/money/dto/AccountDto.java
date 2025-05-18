package com.example.money.dto;

public class AccountDto {

    private String name;
    private double amount;
    private double withdrawalAmount;
    private String withdrawalEmail;
    private String replenisherEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
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
