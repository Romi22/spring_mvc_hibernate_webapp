package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.model.Account;
import com.luv2code.springdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    //need to inject our AccountService
    @Autowired
    private AccountService accountService;


    public AccountController()
    {
        System.out.println("init done");
    }

    @GetMapping("/list")
    public String listAccounts(Model theModel) {

        //get customer from dao
        List<Account> accountsList=accountService.getAccounts();

        //add the customers to the model
        theModel.addAttribute("customer",accountsList);

        return "list-accounts";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Account theAccount=new Account();

        theModel.addAttribute("account",theAccount);

        return "account-form";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account theAccount)
    {
        accountService.saveAccount(theAccount);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpadate")
    public String  showFormForUpdate(@RequestParam("accountID") int theId,Model theModel)
    {
        //get the account from the database
        Account theAccount = accountService.getAccount(theId);

        //set the account as a model attribute to pre-populate the form
        theModel.addAttribute("account",theAccount);

        //send to our form
        return "account-form";
    }

    @GetMapping("/delete")
    public String deleteAccount(@RequestParam("accountID") int theId){

        accountService.deleteAccount(theId);

        return "redirect:/customer/list";
    }

}
