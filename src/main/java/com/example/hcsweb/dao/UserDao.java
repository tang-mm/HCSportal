package com.example.hcsweb.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.users.User;
 

public interface UserDao extends GenericDao<User, Integer> {

	public User getUserByUsername(String username); 

	public List<User> findUsersByCostumerId(int custId);
	public List<User> findUsersByFirstName(String firstName);
	public List<User> findUsersByLastName(String lastName);
	public List<User> findUsersByUserType(int userTypeId);
	public List<User> findUsersByUserTypeAndCostumerId(int userTypeId, int custId);
	
	public List<User> findUsersWithTenantAccess(int tenantId);
	public List<User> findUsersWithServiceAccess(int serviceId);
	public List<User> findUsersWithSiteAccess(int siteId);
	
}