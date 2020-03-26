package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImp extends CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();

        //create a query
        List<Customer> customerList = currentSession.createQuery("from customer order by name").list();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession=sessionFactory.getCurrentSession();

        //method for save and update
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId)
    {
        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Customer theCustomer= (Customer) currentSession.load(Customer.class,(theId));

        return theCustomer;

    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();

        Customer c = (Customer) currentSession.load(Customer.class,theId);

        if(null != c){
            currentSession.delete(c);
        }

    }
}
