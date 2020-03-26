package com.luv2code.springdemo.service;


import com.luv2code.springdemo.dao.TransactionDAO;
import com.luv2code.springdemo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService
{
    //need to inject customer dao
    @Autowired
    private TransactionDAO transactionDAO;

    @Override
    @Transactional
    public List<Transaction> getTransactions() {
        return transactionDAO.getTransactions();
    }

    @Override
    @Transactional
    public void saveTransaction(Transaction theTransaction) {

        transactionDAO.saveTransaction(theTransaction);
    }

    @Override
    @Transactional
    public Transaction getTransaction(int theId) {

        return  transactionDAO.getTransaction(theId);

    }

    @Override
    @Transactional
    public void deleteTransaction(int theId) {

        transactionDAO.deleteTransaction(theId);
    }

    @Override
    public String debit(int theId) {
        return transactionDAO.debit(theId);
    }

    @Override
    public String credit(int theId) {
        return transactionDAO.credit(theId);
    }

    @Override
    public String checkBalance(int theId) {
         return transactionDAO.credit(theId);
    }
}
