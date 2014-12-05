package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.ServiceDao;
import com.example.hcsweb.model.Service;
import com.example.hcsweb.service.ServiceService;

@org.springframework.stereotype.Service("serviceService")
@Transactional
public class ServiceServiceImpl implements ServiceService {

	private ServiceDao serviceDao;
	
	@Override
	public Service findServiceById(int id) throws HibernateException {
		Service service = serviceDao.getById(new Integer(id));
		if (service == null)
			throw new HibernateException("Service not found: id = "+ id);
		return service;
	}

	@Override
	public Service findServiceByName(String code) throws HibernateException {
		Service service = serviceDao.getServiceByName(code);
		if (service == null)
			throw new HibernateException("Service not found: code = "+ code);
		return service;
	}

	@Override
	public List<Service> findServicesByTenantId(int tenantId) { 
		return serviceDao.findServicesByTenantId(tenantId);
	}

	@Override
	public void saveService(Service service) {
		serviceDao.saveOrUpdate(service);
	}

	@Override
	public void deleteService(int id) throws HibernateException {
		serviceDao.delete(new Integer(id));
	}

	@Override
	public List<Service> getAllServices() {
		return serviceDao.getAll();
	}

}
