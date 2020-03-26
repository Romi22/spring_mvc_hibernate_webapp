package com.luv2code.springdemo.dao;


import com.luv2code.springdemo.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImp implements TransactionDAO
{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Transaction> getTransactions() {

        //get the current hibernate session

        Session currentSession=sessionFactory.getCurrentSession();

        //create a query
        List<Transaction> transactionList = currentSession.createQuery("from transaction").list();

        return transactionList;
    }

    @Override
    public void saveTransaction(Transaction theTransaction) {
        Session currentSession=sessionFactory.getCurrentSession();

        //method for save and update
        currentSession.saveOrUpdate(theTransaction);
    }

    @Override
    public Transaction getTransaction(int theId)
    {
        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Transaction theTransaction = (Transaction) currentSession.load(Transaction.class,(theId));

        return theTransaction;

    }

    @Override
    public void deleteTransaction(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();

        Transaction t = (Transaction) currentSession.load(Transaction.class,theId);

        if(null != t){
            currentSession.delete(t);
        }



    }

    @Override
    public String debit(int theId) {

        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Transaction transaction = (Transaction) currentSession.load(Transaction.class,(theId));
        return null;
    }

    @Override
    public String credit(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Transaction theTransaction = (Transaction) currentSession.load(Transaction.class,(theId));
        return null;
    }

    @Override
    public String checkBalance(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Transaction theTransaction = (Transaction) currentSession.load(Transaction.class,(theId));
        return null;
    }
}
