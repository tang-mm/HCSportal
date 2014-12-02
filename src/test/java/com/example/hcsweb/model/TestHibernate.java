package com.example.hcsweb.model;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.hcsweb.dao.CustomerDao;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Test: Customer - Tenant");
//		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		session.beginTransaction();
//		
//
//		Customer cust = new Customer(1, "cust1", "customer 1");
//		session.save(cust);
//		Tenant tenant1 = new Tenant(1, "tenant1", "ip1", "Tenant 1", 24);
//		Tenant tenant2 = new Tenant(2, "tenant2", "ip2", "Tenant 2", 24);
//
//		List<Tenant> listTenant = new ArrayList<Tenant>();
//		listTenant.add(tenant1);
//		listTenant.add(tenant2);
//
//		cust.setListTenant(listTenant);
//
//		
//		for (Tenant t : listTenant) {
//			session.save(t);
//		}
//
//		session.getTransaction().commit();
		
		 ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("hibernate-context.xml");
		 CustomerDao custDao = (CustomerDao) context.getBean("customerDao");
		 Customer cust = new Customer();
		 cust.setCustomerName("cust222");
		 cust.setDescription("I'm Customer 2");
		 custDao.saveOrUpdate(cust);
		 System.out.println("Customer::" + cust);
		 List<Customer> list = custDao.getAll();
		 
		 for(Customer c: list) {
			 System.out.println("Customer List::" + c);
		 }
		 context.close();
		System.out.println("Done");
	}

}
