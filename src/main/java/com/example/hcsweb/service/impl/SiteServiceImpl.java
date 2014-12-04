package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.SiteDao;
import com.example.hcsweb.model.Site;
import com.example.hcsweb.model.Tenant;
import com.example.hcsweb.service.SiteService;

@Service("siteService")
@Transactional
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao siteDao;
	
	@Override
	public Site findSiteById(int id) throws HibernateException {
		Site site = siteDao.getById(new Integer(id));
		if (site == null)
			throw new HibernateException("Site not found: id = "+ id);
		return site;
	}

	@Override
	public Site findSiteByName(String code) throws HibernateException {
		Site site = siteDao.getSiteByName(code);
		if (site == null)
			throw new HibernateException("Site not found: code = "+ code);
		return site;
	}

	@Override
	public void saveSite(Site site) {
		siteDao.saveOrUpdate(site);
	}

	@Override
	public void deleteSite(int id) throws HibernateException {
		siteDao.delete(new Integer(id));
	}

	@Override
	public List<Site> getAllSites() {
		return siteDao.getAll();
	}

	@Override
	public List<Site> findSitesByServiceId(int serviceId) {
		return siteDao.findSitesByServiceId(serviceId);
	}

	@Override
	public List<Site> findSitesByLocationId(int locationId) {
		return siteDao.findSitesByLocationId(locationId);
	}

	@Override
	public List<Site> findSitesByLocationAndServiceId(int locationId, int serviceId) {
		return siteDao.findSitesByLocationAndServiceId(locationId, serviceId);
	}

	@Override
	public List<Site> findSitesByScheduleId(int scheduleId) {
		return siteDao.findSitesByScheduleId(scheduleId);
	} 

}
