package com.example.hcsweb.service;

import com.example.hcsweb.model.Customer;


public interface CustomerService {
	
	Customer findCustomerByName(String custName);
	void saveCustomer(Customer cust);
	void deleteCustomer(String custName);
//	List<Customer> findCustomers()
	
}