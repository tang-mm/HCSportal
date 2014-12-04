package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Tenant;

public interface TenantService {

	Tenant findTenantById(int id) throws HibernateException;

	Tenant findTenantByName(String tenantName) throws HibernateException;

	void saveTenant(Tenant tenant);

	void deleteTenant(int id) throws HibernateException;

	List<Tenant> getAllTenants();
	
	List<Tenant> findTenantsByCustomerId(int custId);

}