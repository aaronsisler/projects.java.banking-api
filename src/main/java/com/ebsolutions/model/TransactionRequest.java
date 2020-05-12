package com.ebsolutions.model;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class TransactionRequest {
    private String transactionType;
    private Account account;

    public TransactionRequest() {
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
