package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.users.User;


public interface UserService { 
	
	User authenticate(String username, String password) throws Exception;
	boolean matchPassword(User user, String pwToCompare) ;
	
	User findUserById(int id) throws HibernateException;
	User findUserByUsername(String username) throws HibernateException;
	List<User> findUsersByFirstName(String firstName) throws HibernateException;
	List<User> findUsersByLastName(String lastName) throws HibernateException;
	
	void saveUser(User user);
	void deleteUser(int id) throws HibernateException;
	List<User> getAllUsers();
	
	List<User> findUsersWithTenantAccess(int tenantId);
	public List<User> findUsersByUserType(int userTypeId);
	public List<User> findUsersByUserTypeAndCostumerId(int userTypeId, int custId);
}