package com.example.hcsweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.UserTypeDao;
import com.example.hcsweb.model.users.UserType;

@Repository("userTypeDao")
public class UserTypeDaoImpl extends AbstractGenericDaoImpl<UserType, Integer> implements UserTypeDao {

	@Override
	public UserType getUserTypeByName(String typeName) {
		@SuppressWarnings("unchecked")
		List<UserType> list = getSession().createQuery("FROM UserType WHERE user_type = ? ").setParameter(0, typeName)
				.list();
		return (list.isEmpty() ? null : list.get(0));
	}

}
