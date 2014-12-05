package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Site;

public interface SiteService {

	Site findSiteById(int id) throws HibernateException;

	Site findSiteByName(String siteName) throws HibernateException;

	void saveSite(Site site);

	void deleteSite(int id) throws HibernateException;

	List<Site> getAllSites();

	List<Site> findSitesByServiceId(int serviceId);

	List<Site> findSitesByLocationId(int locationId);

	List<Site> findSitesByLocationAndServiceId(int locationId, int serviceId);

	List<Site> findSitesByScheduleId(int scheduleId);
}