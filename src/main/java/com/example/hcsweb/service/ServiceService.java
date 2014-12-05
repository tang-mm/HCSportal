package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Service;

public interface ServiceService {

	Service findServiceById(int id) throws HibernateException;

	Service findServiceByName(String serviceName) throws HibernateException;

	void saveService(Service service);

	void deleteService(int id) throws HibernateException;

	List<Service> getAllServices();

	List<Service> findServicesByTenantId(int tenantId);
}
