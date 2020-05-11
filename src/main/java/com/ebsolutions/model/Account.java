package com.ebsolutions.model;

public class Account {
    private int accountId;
    private final String accountNumber;
    private final String accountOwner;
    private double accountBalance;

    public Account(int accountId, String accountNumber, String accountOwner, double accountBalance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
