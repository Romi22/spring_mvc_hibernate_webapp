package com.luv2code.springdemo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String branchCode;

    String branchName;

    @OneToMany
    private List<Customer> customer=new ArrayList<>();

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", branchCode='" + branchCode+
                '}';
    }
}