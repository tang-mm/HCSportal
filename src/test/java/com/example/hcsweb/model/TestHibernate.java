package com.example.hcsweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.hcsweb.dao.CustomerDao;
import com.example.hcsweb.model.users.User;
import com.example.hcsweb.model.users.UserType;
import com.example.hcsweb.service.CustomerService;
import com.example.hcsweb.service.TenantService;
import com.example.hcsweb.service.UserService;
import com.example.hcsweb.service.UserTypeService;

public class TestHibernate {
	@Autowired
	private CustomerService custService;

	public static void main(String[] args) {
		System.out.println("Test: Customer - Tenant");
		TestHibernate test = new TestHibernate();
		test.testNewUser();
		// test.testDao();
		// test.testCustService();
		// test.testCustTenantService();
		// test.testUserTenantJoin();
		System.out.println("Done");
	}

	public void testDao() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"hibernate-context.xml");
		CustomerDao custDao = (CustomerDao) context.getBean("customerDao");
		// Customer cust = new Customer();
		// cust.setCustomerName("cust444");
		// cust.setDescription("I'm Customer 2");
		// System.out.println("Save or update");
		// custDao.saveOrUpdate(cust);
		// System.out.println("Customer::" + cust);
		List<Customer> list = null;
		Customer cust = custDao.getCustomerByName("cust1111");
		list.add(cust);
		for (Customer c : list) {
			System.out.println("Customer List: name = " + c.getCustomerName());
		}
		// context.close();
	}

	public void testNewUser() {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"hibernate-context.xml");
		UserService userService = (UserService) context.getBean("userService");
		UserTypeService typeService = (UserTypeService) context.getBean("userTypeService");
		CustomerService custService = (CustomerService) context.getBean("customerService");
		UserType type = typeService.findUserTypeByName("SuperAdmin");
		Customer cust = custService.findCustomerByName("Orange");
		User user = new User("SuperAdmin", userService.encryptInputPassword("password"), type, true);
		user.setCustomer(cust);
		user.setCreationTime(new Timestamp((new Date()).getTime()));
		userService.saveUser(user);
	}

	public void testCustService() {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"hibernate-context.xml");
		CustomerService custService = (CustomerService) context.getBean("customerService");
		Customer cust = custService.findCustomerByName("cust1111");
		System.out.println(cust.getDescription());
		Customer cust2 = custService.findCustomerByName("cust00");
		System.out.println(cust2.getDescription());
	}

	public void testCustTenantService() {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"hibernate-context.xml");
		CustomerService custService = (CustomerService) context.getBean("customerService");
		TenantService tenantService = (TenantService) context.getBean("tenantService");
		Customer cust = custService.findCustomerByName("cust1111");
		Tenant ten = new Tenant("cust1111_tenant1", "172.100.100.0", "I'm Tenant 1 of Customer 1");
		ten.setCustomer(cust);
		System.out.println("saveTenant");
		tenantService.saveTenant(ten);
		List<Tenant> listT = tenantService.getAllTenants();
		for (Tenant t : listT) {
			System.out.println(t.getDescription());
		}
	}

	public void testUserTenantJoin() {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"hibernate-context.xml");
		// CustomerService custService = (CustomerService)
		// context.getBean("customerService");
		TenantService tenantService = (TenantService) context.getBean("tenantService");
		// Customer cust = custService.findCustomerByName("cust1111");
		Tenant ten = tenantService.findTenantById(1);
		List<Tenant> list = new ArrayList<Tenant>();
		list.add(ten);
		System.out.println("------------add");
		Customer cust = ten.getCustomer();
		List<User> users = cust.getListUser();
		UserService userService = (UserService) context.getBean("userService");
		for (User u : users) {
			if (!u.getUsername().equals("superAdmin")) {
				u.setListTenant(list);
				userService.saveUser(u);
			}
		}
		// User user1 = userService.findUserByUsername("user1");
		// User user2 = userService.findUserByUsername("user2");
		// Customer cust = user0.getCustomer();
		//
		// User user = new User("user3", "password3", new UserType(1,
		// "hypervisor"), true);
		//
		// user.setCreatedBy(user0);
		// user.setCreationTime(new Timestamp(new Date().getTime()));
		// user.setCustomer(cust);
		// user.setFirstName("first3");
		// user.setLastName("last3");
		// user.setLastLoggedIn(new Timestamp(2014));
		// user1.setListTenant(list);
		// user2.setListTenant(list);
		// userService.saveUser(user1);
		// userService.saveUser(user2);
		int tenantId = 1;
		User user = userService.findUsersWithTenantAccess(tenantId).get(0);
		System.out.println(user.getUsername());
	}
}