package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Customer;
 

public interface CustomerDao extends GenericDao<Customer, Integer> {

    public Customer getCustomerByName(String custName);

}