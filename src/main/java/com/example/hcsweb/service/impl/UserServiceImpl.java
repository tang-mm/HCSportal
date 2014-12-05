package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.UserDao;
import com.example.hcsweb.model.users.User;
import com.example.hcsweb.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User authenticate(String username, String password) throws Exception {
		User user = userDao.getUserByUsername(username);
		boolean result = this.matchPassword(user, password);

		if (result == false) {
			throw new Exception("Password does not match");
		}
		return user;
	}

	@Override
	public boolean matchPassword(User user, String pwToCompare) {
		String pw = user.getPassword();

		if (pw.compareTo(pwToCompare) == 0)
			return true;
		else
			return false;
	}

	/**
	 * encrypt plain-text password
	 * @param plainPassword
	 * @return
	 */
	@Override
	public String encryptInputPassword(String plainPassword) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(plainPassword);
	}
	
	
	@Override
	public User findUserById(int id) throws HibernateException {
		User user = userDao.getById(new Integer(id));
		if (user == null)
			throw new HibernateException("User not found: id = "+ id);
		return user;
	}

	@Override
	public User findUserByUsername(String username) throws HibernateException {
		User user = userDao.getUserByUsername(username);
		if (user == null)
			throw new HibernateException("User not found: username = "+ username);
		return user;
	}

	@Override
	public List<User> findUsersByFirstName(String firstName) throws HibernateException {
		List<User> listUser = userDao.findUsersByFirstName(firstName);
		if (listUser == null)
			throw new HibernateException("User not found: firstName = "+ firstName);
		return listUser;
	}

	@Override
	public List<User> findUsersByLastName(String lastName) throws HibernateException {
		List<User> listUser = userDao.findUsersByLastName(lastName);
		if (listUser == null)
			throw new HibernateException("User not found: lastName = "+ lastName);
		return listUser;
	}

	@Override
	public void saveUser(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) throws HibernateException {
		userDao.delete(new Integer(id));
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public List<User> findUsersWithTenantAccess(int tenantId) {
		return userDao.findUsersWithTenantAccess(tenantId);
	}

	@Override
	public List<User> findUsersByUserType(int userTypeId) {
		return userDao.findUsersByUserType(userTypeId);
	}

	@Override
	public List<User> findUsersByUserTypeAndCostumerId(int userTypeId, int custId) {
		return userDao.findUsersByUserTypeAndCostumerId(userTypeId, custId);
	}

}
