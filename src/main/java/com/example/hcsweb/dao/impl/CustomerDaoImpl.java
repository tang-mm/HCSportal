package com.example.hcsweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.CustomerDao;
import com.example.hcsweb.model.Customer;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends AbstractGenericDaoImpl<Customer, Integer> implements CustomerDao {

	public CustomerDaoImpl() {
		super("customers");
	}

	public Customer findByName(String custName) {
		@SuppressWarnings("unchecked")
		List<Customer> list =   getSessionFactory().getCurrentSession().createQuery("FROM customers WHERE customer_name = ? ").setParameter(0, custName).list();
		return (list.isEmpty() ? null : list.get(0));
	}	
	
}
