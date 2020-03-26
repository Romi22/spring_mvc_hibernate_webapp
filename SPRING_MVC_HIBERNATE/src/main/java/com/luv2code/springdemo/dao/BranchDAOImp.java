package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchDAOImp implements BranchDAO
{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Branch> getBranches() {

        //get the current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();

        //create a query
        List<Branch> branchList = currentSession.createQuery("from branch order by name").list();

        return branchList;
    }

    @Override
    public void saveBranch(Branch theBranch) {
        Session currentSession=sessionFactory.getCurrentSession();

        //method for save and update
        currentSession.saveOrUpdate(theBranch);
    }

    @Override
    public Branch getBranch(int theId)
    {
        Session currentSession=sessionFactory.getCurrentSession();
        // read from database using the primary key
        Branch theBranch = (Branch) currentSession.load(Branch.class,(theId));

        return theBranch;

    }

    @Override
    public void deleteBranch(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();

        Branch b = (Branch) currentSession.load(Branch.class,theId);

        if(null != b){
            currentSession.delete(b);
        }

    }
}
