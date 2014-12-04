package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Service;
import com.example.hcsweb.model.Site;

public interface ServiceDao extends GenericDao<Service, Integer> {

	public Service getServiceByName(String code);

	public List<Service> findServicesByTenantId(int tenantId);
}