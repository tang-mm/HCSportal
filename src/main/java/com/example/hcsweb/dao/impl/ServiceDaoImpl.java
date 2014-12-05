package com.example.hcsweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.ServiceDao;
import com.example.hcsweb.model.Service;

@Repository("serviceDao")
public class ServiceDaoImpl extends AbstractGenericDaoImpl<Service, Integer> implements ServiceDao {

	@Override
	public Service getServiceByName(String code) {
		@SuppressWarnings("unchecked")
		List<Service> lst = getSession().createQuery("FROM Service WHERE service_code = ? ").setParameter(0, code)
				.list();
		return (lst.isEmpty() ? null : lst.get(0));
	}

	@Override
	public List<Service> findServicesByTenantId(int tenantId) {
		Criterion c = Restrictions.eq("tenant.tenantId", tenantId);
		return findByCriteria(null, c);
	}
}
