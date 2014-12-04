package com.example.hcsweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.SiteDao;
import com.example.hcsweb.model.Site;

@Repository("siteDao")
public class SiteDaoImpl extends AbstractGenericDaoImpl<Site, Integer> implements SiteDao {

	@Override
	public Site getSiteByName(String siteCode) {
		@SuppressWarnings("unchecked")
		List<Site> lst = getSessionFactory().getCurrentSession().createQuery("FROM Site WHERE site_name = ? ").setParameter(0, siteCode).list();
		return (lst.isEmpty() ? null : lst.get(0));
	}

	@Override
	public List<Site> findSitesByServiceId(int serviceId) {
		Criterion c = Restrictions.eq("service.serviceId", serviceId);
		return findByCriteria(null, c);
	}

	@Override
	public List<Site> findSitesByLocationId(int locationId) {
		Criterion c = Restrictions.eq("location.locationId", locationId);
		return findByCriteria(null, c);
	}

	@Override
	public List<Site> findSitesByLocationAndServiceId(int locationId, int serviceId) {
		Criterion c1 = Restrictions.eq("location.locationId", locationId);
		Criterion c2 = Restrictions.eq("service.serviceId", serviceId);
		return findByCriteria(null, c1, c2);
	}

	@Override
	public List<Site> findSitesByScheduleId(int scheduleId) {
		Criterion c = Restrictions.eq("schedule.scheduleId", scheduleId);
		return findByCriteria(null, c);
	}
 
}