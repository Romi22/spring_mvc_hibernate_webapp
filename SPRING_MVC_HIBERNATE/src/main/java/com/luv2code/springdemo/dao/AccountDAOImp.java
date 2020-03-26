package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImp implements AccountDAO
{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Account> getAccounts() {

        //get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();

        //create a query
        List<Account> accountList = currentSession.createQuery("from account order by name").list();

        return accountList;
    }

    @Override
    public void saveAccount(Account theAccount) {
        Session currentSession=sessionFactory.getCurrentSession();

        //method for save and update
        currentSession.saveOrUpdate(theAccount);
    }

    @Override
    public Account getAccount(int theId)
    {
        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Account theAccount = (Account) currentSession.load(Account.class,(theId));

        return theAccount;

    }

    @Override
    public void deleteAccount(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();

        Account a = (Account) currentSession.load(Account.class,theId);

        if(null != a){
            currentSession.delete(a);
        }

    }
}
