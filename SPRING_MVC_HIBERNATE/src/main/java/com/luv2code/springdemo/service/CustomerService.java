package com.luv2code.springdemo.service;

import com.luv2code.springdemo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service
public interface CustomerService
{
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

   public void deleteCustomer(int theId);
}
