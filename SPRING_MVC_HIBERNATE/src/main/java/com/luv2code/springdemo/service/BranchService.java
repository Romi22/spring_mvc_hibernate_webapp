package com.luv2code.springdemo.service;


import com.luv2code.springdemo.model.Branch;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface BranchService
{
    public List<Branch> getBranches();

    public void saveBranch(Branch theBranch);

    public Branch getBranch(int theId);

    public void deleteBranch(int theId);
}
