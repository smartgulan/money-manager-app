package com.example.money.model;

import com.example.money.dto.AccountDto;
import com.example.money.model.core.UserEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account extends UserEntity {

    @Column
    private String name;

    @Column
    private BigDecimal balance = BigDecimal.valueOf(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountDto toAccountDto() {
        AccountDto accountDto = new AccountDto();
        accountDto.setName(this.getName());
        return accountDto;
    }

}
