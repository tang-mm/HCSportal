package com.example.hcsweb.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.CustomerDao;
import com.example.hcsweb.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractGenericDaoImpl<Customer, Integer> implements CustomerDao {

	@Override
	public Customer getCustomerByName(String custName) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Customer> lst = session.createQuery("FROM Customer WHERE customer_name = ? ").setParameter(0, custName).list();
		trans.commit();
		
		return (lst.isEmpty() ? null : lst.get(0));
	}
 
	/**
	 * return all customers in DB except Orange 
	 */
	@Override
	public List<Customer> getAll(){
		
		int orangeId = 1;
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Customer> list = session.createQuery("FROM Customer WHERE customer_id != ? ").setParameter(0, orangeId).list();
		trans.commit();
	
		return list;
	}
}
