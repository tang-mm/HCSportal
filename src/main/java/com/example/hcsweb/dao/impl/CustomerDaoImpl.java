package com.example.hcsweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.CustomerDao;
import com.example.hcsweb.model.Customer;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends AbstractGenericDaoImpl<Customer, Integer> implements CustomerDao {

	@Override
	public Customer getCustomerByName(String custName) {
		@SuppressWarnings("unchecked")
		List<Customer> lst = getSessionFactory().getCurrentSession().createQuery("FROM Customer WHERE customer_name = ? ").setParameter(0, custName).list();
		return (lst.isEmpty() ? null : lst.get(0));
		 
	}
 
}
