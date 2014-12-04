package com.example.hcsweb.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
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
		Criterion c = Restrictions.eq("customer.customerId", custId);
		return findByCriteria(null, c);
	}

	@Override
	public List<User> findUsersByUserType(int userTypeId) {
		Criterion c = Restrictions.eq("userType.userTypeId", userTypeId);
		return findByCriteria(null, c);
	}

	@Override
	public List<User> findUsersByUserTypeAndCostumerId(int userTypeId, int custId) {
		Criterion c1 = Restrictions.eq("customer.customerId", custId);
		Criterion c2 = Restrictions.eq("userType.userTypeId", userTypeId);
		return findByCriteria(null, c1, c2);
	}

	@Override
	public List<User> findUsersWithTenantAccess(int tenantId) {
		HashMap<String, String> aliases = new HashMap<String, String>();
		aliases.put("listTenant", "tenant");

		Criterion c = Restrictions.eq("tenant.tenantId", tenantId);
		return findByCriteria(aliases, c);
	}

	@Override
	public List<User> findUsersWithServiceAccess(int serviceId) {
		HashMap<String, String> aliases = new HashMap<String, String>();
		aliases.put("listService", "service");

		Criterion c = Restrictions.eq("service.serviceId", serviceId);
		return findByCriteria(aliases, c);
	}

	@Override
	public List<User> findUsersWithSiteAccess(int siteId) {
		HashMap<String, String> aliases = new HashMap<String, String>();
		aliases.put("listSite", "site");

		Criterion c = Restrictions.eq("site.siteId", siteId);
		return findByCriteria(aliases, c);
	}

	@Override
	public List<User> findUsersByFirstName(String firstName) {
		return findByCriteria(null, Restrictions.like("first_name", firstName, MatchMode.START));
	}

	@Override
	public List<User> findUsersByLastName(String lastName) {
		return findByCriteria(null, Restrictions.like("last_name", lastName, MatchMode.START));
	}

}