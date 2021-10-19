package com.whitecloak.digitalbank.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_accounts")
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    public UserAccountEntity(Long id, UserEntity userEntity, Long accountNumber, BigDecimal balance) {
        this.id = id;
        this.userEntity = userEntity;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public UserAccountEntity() {
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
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
