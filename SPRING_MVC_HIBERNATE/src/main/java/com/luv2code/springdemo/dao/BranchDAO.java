package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.model.Branch;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BranchDAO
{
    public List<Branch> getBranches();

    public void saveBranch(Branch theBranch);

    public Branch getBranch(int theId);

    public void deleteBranch(int theId);
}
