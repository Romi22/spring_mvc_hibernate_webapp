package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.BranchDAO;
import com.luv2code.springdemo.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BranchServiceImp implements BranchService
{
    //need to inject customer dao
    @Autowired
    private BranchDAO branchDAO;

    @Override
    @Transactional
    public List<Branch> getBranches() {
        return branchDAO.getBranches();
    }

    @Override
    @Transactional
    public void saveBranch(Branch theBranch) {

        branchDAO.saveBranch(theBranch);
    }

    @Override
    @Transactional
    public Branch getBranch(int theId) {

        return  branchDAO.getBranch(theId);

    }

    @Override
    @Transactional
    public void deleteBranch(int theId) {

        branchDAO.deleteBranch(theId);
    }
}
