package com.luv2code.springdemo.dao;


import com.luv2code.springdemo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public abstract class CustomerDAO
{
    public abstract List<Customer> getCustomers();

    public abstract void saveCustomer(Customer theCustomer);

    public abstract Customer  getCustomer(int theId);

    public abstract void deleteCustomer(int theId);
}
