package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Customer;


public interface CustomerService {
	
	Customer findCustomerById(int id) throws HibernateException;
	Customer findCustomerByName(String custName) throws HibernateException;
	void saveCustomer(Customer cust);
	void deleteCustomer(int id) throws HibernateException;
	List<Customer> getAllCustomers() ;
		
}