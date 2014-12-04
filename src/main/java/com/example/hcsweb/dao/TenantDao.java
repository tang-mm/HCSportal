package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Tenant;
 

public interface TenantDao extends GenericDao<Tenant, Integer> {

    public Tenant getTenantByName(String tenantName);
	public List<Tenant> findTenantsByCustomerId(int custId);
    
    
}