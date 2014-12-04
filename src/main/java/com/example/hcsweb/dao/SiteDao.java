package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Site;
 

public interface SiteDao extends GenericDao<Site, Integer> {
 
    public Site getSiteByName(String siteCode);
	public List<Site> findSitesByServiceId(int serviceId);
	public List<Site> findSitesByLocationId(int locationId);
	public List<Site> findSitesByLocationAndServiceId(int locationId, int serviceId);
	public List<Site> findSitesByScheduleId(int scheduleId);
}