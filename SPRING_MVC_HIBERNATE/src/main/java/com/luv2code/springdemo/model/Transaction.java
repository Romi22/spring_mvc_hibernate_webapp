package com.luv2code.springdemo.model;

import javax.persistence.*;

@Entity
@Table(name="transaction")
public class Transaction
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String transactionID;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                '}';
    }
}
