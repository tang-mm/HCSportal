package com.example.hcsweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.ServiceDao;
import com.example.hcsweb.model.Service;

@Repository("serviceDao")
public class ServiceDaoImpl extends AbstractGenericDaoImpl<Service, Integer> implements ServiceDao {

	@Override
	public Service getServiceByName(String code) {
		@SuppressWarnings("unchecked")
		List<Service> lst = getSessionFactory().getCurrentSession().createQuery("FROM Service WHERE service_code = ? ").setParameter(0, code).list();
		return (lst.isEmpty() ? null : lst.get(0));
	}

		
}
