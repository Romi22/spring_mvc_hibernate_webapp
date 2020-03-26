package com.luv2code.springdemo.model;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String accountID;
    String accountType;
    Integer accountNo;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accpuntNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountNo=" + accountNo +
                '}';
    }
}
