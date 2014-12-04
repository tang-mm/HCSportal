package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.users.UserType;

public interface UserTypeService { 
	
	UserType findUserTypeById(int id) throws HibernateException;
	UserType findUserTypeByName(String typeName) throws HibernateException;
	
	void saveUserType(UserType userType);
	void deleteUserType(int id) throws HibernateException;
	List<UserType> getAllUserTypes() ;
}