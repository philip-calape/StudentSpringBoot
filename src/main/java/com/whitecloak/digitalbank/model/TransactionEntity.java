package com.whitecloak.digitalbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("source_account")
    @Column(name = "source_account")
    private Long sourceAccount;

    @JsonProperty("target_account")
    @Column(name = "target_account")
    private Long targetAccount;

    @JsonProperty("amount")
    @Column(name = "amount")
    private BigDecimal amount;

    @JsonProperty("ending_balance")
    @Column(name = "ending_balance")
    private BigDecimal endingBalance;


    public TransactionEntity(Long id, Long sourceAccount, Long targetAccount, BigDecimal amount, BigDecimal endingBalance) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
        this.endingBalance = endingBalance;
    }

    public TransactionEntity() {
    }

    public BigDecimal getEndingBalance() {
        return endingBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getTargetAccount() {
        return targetAccount;
    }

    public Long getSourceAccount() {
        return sourceAccount;
    }

    public Long getId() {
        return id;
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
    }
}
