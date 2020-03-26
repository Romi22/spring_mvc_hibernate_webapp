package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Repository
public interface TransactionDAO
{
    public List<Transaction> getTransactions();

    public void saveTransaction(Transaction theTransaction);

    public Transaction getTransaction(int theId);

    public void deleteTransaction(int theId);

    public String debit(int theId);

    public String credit(int theId);

    public String checkBalance(int theId);
}
