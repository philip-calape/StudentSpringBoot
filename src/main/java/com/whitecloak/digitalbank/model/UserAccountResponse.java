package com.whitecloak.digitalbank.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserAccountResponse {

    private Long userId;
    private Long accountNumber;
    private BigDecimal balance;

    public UserAccountResponse() { }

    public UserAccountResponse(Long userId, Long accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}