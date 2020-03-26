package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.model.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject our CustomerService
    @Autowired
    private CustomerService customerService;


    public CustomerController()
    {
        System.out.println("init done");
    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

       // System.out.println("********************************************************************************************");

        //get customer from dao
        List<Customer> customerList=customerService.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customer",customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Customer theCustomer=new Customer();

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpadate")
        public String  showFormForUpdate(@RequestParam("customerId") int theId,Model theModel)
    {
        //get the customer from the database
        Customer theCustomer = customerService.getCustomer(theId);

        //set the customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);

        //send to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
