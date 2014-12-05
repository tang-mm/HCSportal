package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.TenantDao;
import com.example.hcsweb.model.Tenant;
import com.example.hcsweb.service.TenantService;
 

@Service("tenantService")
@Transactional
public class TenantServiceImpl implements TenantService{

	@Autowired
	private TenantDao tenantDao;

	@Override
	public Tenant findTenantById(int id) throws HibernateException {
		Tenant tenant = tenantDao.getById(new Integer(id));
		if (tenant == null)
			throw new HibernateException("Tenant not found: id = "+ id);
		return tenant;
	}

	@Override
	public Tenant findTenantByName(String tenantName) throws HibernateException {
		Tenant tenant = tenantDao.getTenantByName(tenantName);
		if (tenant == null)
			throw new HibernateException("Tenant not found: name = "+ tenantName);
		return tenant;
	}

	@Override
	public void saveTenant(Tenant tenant) {
		tenantDao.saveOrUpdate(tenant);
	}

	@Override
	public void deleteTenant(int id) throws HibernateException {
		tenantDao.delete(new Integer(id));
	}

	@Override
	public List<Tenant> getAllTenants() {
		return tenantDao.getAll();
	}

	@Override
	public List<Tenant> findTenantsByCustomerId(int custId) {
		return tenantDao.findTenantsByCustomerId(custId);
	}
 
	
}
