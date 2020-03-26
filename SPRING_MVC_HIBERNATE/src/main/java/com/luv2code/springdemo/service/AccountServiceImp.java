package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.AccountDAO;
import com.luv2code.springdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService
{
    //need to inject customer dao
    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    @Transactional
    public void saveAccount(Account theAccount) {

        accountDAO.saveAccount(theAccount);
    }

    @Override
    @Transactional
    public Account getAccount(int theId) {

        return  accountDAO.getAccount(theId);

    }

    @Override
    @Transactional
    public void deleteAccount(int theId) {

        accountDAO.deleteAccount(theId);
    }
}
