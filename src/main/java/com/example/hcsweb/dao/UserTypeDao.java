package com.example.hcsweb.dao;

import com.example.hcsweb.model.users.UserType;
 

public interface UserTypeDao extends GenericDao<UserType, Integer> {

	public UserType getUserTypeByName(String typeName);
    
}