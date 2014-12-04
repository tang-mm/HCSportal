package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.CustomerDao;
import com.example.hcsweb.model.Customer;
import com.example.hcsweb.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;


	@Override
	public Customer findCustomerById(int id) throws HibernateException {
		Customer cust = customerDao.getById(new Integer(id));
		if (cust == null)
			throw new HibernateException("Customer not found: id = "+ id);
		return cust;
	}	
	
	@Override
	public Customer findCustomerByName(String custName) throws HibernateException{
		Customer cust = customerDao.getCustomerByName(custName);
		if (cust == null)
			throw new HibernateException("Customer not found: name = "+ custName);
		return cust;
	}

	@Override
	public void saveCustomer(Customer cust) throws HibernateException {
		customerDao.saveOrUpdate(cust);
	}

	@Override
	public void deleteCustomer(int id) throws HibernateException {
		customerDao.delete(new Integer(id));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAll();
	}
	
	
}
