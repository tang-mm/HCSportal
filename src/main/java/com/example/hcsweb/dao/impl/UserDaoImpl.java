package com.example.hcsweb.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.UserDao;
import com.example.hcsweb.model.users.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDaoImpl<User, Integer> implements UserDao {

	@Override
	public User getUserByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> list = getSessionFactory().getCurrentSession().createQuery("FROM User WHERE username = ? ")
				.setParameter(0, username).list();
		return (list.isEmpty() ? null : list.get(0));
	}

	@Override
	public List<User> findUsersByCostumerId(int custId) {
		Criterion c = Restrictions.eq("customerId", custId);
		return findByCriteria(null, c);
	}

	@Override
	public List<User> findUsersWithTenantAccess(int tenantId) {
		// TODO
		// http://www.journaldev.com/2963/hibernate-criteria-example-tutorial
		HashMap<String, String> aliases = new HashMap<String, String>();
		aliases.put("listTenant", "tenant");

		Criterion c = Restrictions.eq("tenant.tenantId", tenantId);
		return findByCriteria(aliases, c);

		/*
		 * Criteria criteria = currentSession.createCriteria(Professor.class,
		 * "professor"); criteria.createAlias("professor.students", "student");
		 * criteria.createAlias("student.assigments", "assigment");
		 * criteria.add(Restrictions.eqProperty("professor.id",
		 * "student.profid"));
		 * criteria.add(Restrictions.eqProperty("assigment.studentid",
		 * "student.profid")); criteria.add(Restrictions.eq("id", 2411)); return
		 * criteria.list();
		 */
	}

}