package com.luv2code.springdemo.controller;


import com.luv2code.springdemo.model.Branch;
import com.luv2code.springdemo.service.BranchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    //need to inject our BranchService
    @Autowired
    private BranchServiceImp branchService;


    public BranchController()
    {
        System.out.println("init done");
    }

    @GetMapping("/list")
    public String listBranch(Model theModel) {

        //get branches from dao
        List<Branch> branchList=branchService.getBranches();

        //add the branches to the model
        theModel.addAttribute("branch",branchList);

        return "list-branches";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Branch theBranch=new Branch();

        theModel.addAttribute("branch",theBranch);

        return "branch-form";
    }

    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("branch") Branch theBranch)
    {
        branchService.saveBranch(theBranch);

        return "redirect:/branch/list";
    }

    @GetMapping("/showFormForUpadate")
    public String  showFormForUpdate(@RequestParam("branchCode") int theId,Model theModel)
    {
        //get the branch from the database
        Branch theBranch=branchService.getBranch(theId);

        //set the branch as a model attribute to pre-populate the form
        theModel.addAttribute("branch",theBranch);

        //send to our form
        return "branch-form";
    }

    @GetMapping("/delete")
    public String deleteBranch(@RequestParam("branchCode") int theId){

        branchService.deleteBranch(theId);

        return "redirect:/branch/list";
    }

}
