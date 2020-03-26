package com.luv2code.springdemo.service;

import com.luv2code.springdemo.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface AccountService
{
    public List<Account> getAccounts();

    public void saveAccount(Account theAccount);

    public Account getAccount(int theId);

    public void deleteAccount(int theId);
}
