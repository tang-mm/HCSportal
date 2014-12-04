package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.users.User;
 

public interface UserDao extends GenericDao<User, Integer> {

	public User getUserByUsername(String username); 

	public List<User> findUsersByCostumerId(int custId);
	
	//TODO join
	public List<User> findUsersWithTenantAccess(int tenantId);
}