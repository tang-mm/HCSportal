package com.example.hcsweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.TenantDao;
import com.example.hcsweb.model.Customer;
import com.example.hcsweb.model.Tenant;

@Repository("tenantDao")
public class TenantDaoImpl extends AbstractGenericDaoImpl<Tenant, Integer> implements TenantDao {

	@Override
	public Tenant getTenantByName(String tenantName) {
		@SuppressWarnings("unchecked")
		List<Tenant> lst = getSessionFactory().getCurrentSession().createQuery("FROM Tenant WHERE tenant_name = ? ").setParameter(0, tenantName).list();
		return (lst.isEmpty() ? null : lst.get(0));
	}
 
}