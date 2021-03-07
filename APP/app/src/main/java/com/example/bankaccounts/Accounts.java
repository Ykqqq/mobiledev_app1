package com.example.bankaccounts;

import java.io.Serializable;

public class Accounts implements Serializable {
    private String accountId;
    private String amount;
    private String iban;
    private String currency;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Accounts()  {
    }

    public Accounts(String accountId, String amount, String iban, String currency) {
        this.accountId = accountId;
        this.amount = amount;
        this.iban = iban;
        this.currency = currency;
    }

    public Accounts(String amount, String iban, String currency) {
        this.amount = amount;
        this.iban = iban;
        this.currency = currency;
    }


    @Override
    public String toString()  {
        return this.accountId;
    }

}
