package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.UserTypeDao;
import com.example.hcsweb.model.users.UserType;
import com.example.hcsweb.service.UserTypeService;

@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	private UserTypeDao userTypeDao;
	
	@Override
	public UserType findUserTypeById(int id) throws HibernateException {
		UserType type = userTypeDao.getById(new Integer(id));
		if (type == null)
			throw new HibernateException("UserType not found: id = "+ id);
		return type;
	}

	@Override
	public UserType findUserTypeByName(String typeName) throws HibernateException {
		UserType type = userTypeDao.getUserTypeByName(typeName);
		if (type == null)
			throw new HibernateException("UserType not found: type = "+ typeName);
		return type;
	}

	@Override
	public void saveUserType(UserType userType) {
		userTypeDao.saveOrUpdate(userType);
	}

	@Override
	public void deleteUserType(int id) throws HibernateException {
		userTypeDao.delete(new Integer(id));
	}

	@Override
	public List<UserType> getAllUserTypes() {
		return userTypeDao.getAll();
	}

}
