package com.example.hcsweb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.CustomerDao;
import com.example.hcsweb.model.Customer;
import com.example.hcsweb.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;

	@Override
	@Transactional
	public Customer findCustomerByName(String custName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteCustomer(String custName) {
		// TODO Auto-generated method stub
		
	}
	
}
