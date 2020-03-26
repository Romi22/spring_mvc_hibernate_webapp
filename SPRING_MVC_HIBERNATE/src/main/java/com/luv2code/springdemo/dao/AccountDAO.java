package com.luv2code.springdemo.dao;


import com.luv2code.springdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface AccountDAO
{
    public List<Account> getAccounts();

    public void saveAccount(Account theAccount);

    public Account getAccount(int theId);

    public void deleteAccount(int theId);
}
