package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.model.Transaction;
import com.luv2code.springdemo.service.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    //need to inject our AccountService
    @Autowired
    private TransactionServiceImp transactionService;


    public TransactionController()
    {
        System.out.println("init done");
    }

    @GetMapping("/list")
    public String listTransactions(Model theModel) {

        //get transactions from dao
        List<Transaction> transactionList=transactionService.getTransactions();

        //add the transactions to the model
        theModel.addAttribute("transaction",transactionList);

        return "list-transactions";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Transaction theTransaction=new Transaction();

        theModel.addAttribute("transaction",theTransaction);

        return "transaction-form";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction theTransaction)
    {
        transactionService.saveTransaction(theTransaction);

        return "redirect:/transaction/list";
    }

    @GetMapping("/showFormForUpadate")
    public String  showFormForUpdate(@RequestParam("TransactionID") int theId,Model theModel)
    {
        //get the transaction from the database
        Transaction theTransaction = transactionService.getTransaction(theId);

        //set the transaction as a model attribute to pre-populate the form
        theModel.addAttribute("transaction",theTransaction);

        //send to our form
        return "transaction-form";
    }

    @GetMapping("/delete")
    public String deleteTransaction(@RequestParam("transactionID") int theId){

        transactionService.deleteTransaction(theId);

        return "redirect:/transaction/list";
    }

    @RequestMapping("/debit")
    public String debit(@RequestParam("transactionID")int theId)
    {
        transactionService.debit(theId);

        return "transaction-debit";
    }

    @RequestMapping("/credit")
    public String credit(@RequestParam("transactionID") int theId)
    {
        transactionService.credit(theId);

        return "transaction-debit";
    }

    @RequestMapping("/checkBalance")
    public String check(@RequestParam("transactionID")int theId)
    {
        transactionService.checkBalance(theId);

        return "transaction-checkBalance";
    }


}
