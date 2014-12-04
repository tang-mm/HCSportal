package com.example.hcsweb.dao;

import com.example.hcsweb.model.Tenant;
 

public interface TenantDao extends GenericDao<Tenant, Integer> {

    public Tenant getTenantByName(String tenantName);
    
    
}