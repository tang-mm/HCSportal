package com.example.hcsweb.dao;

import com.example.hcsweb.model.Site;
 

public interface SiteDao extends GenericDao<Site, Integer> {
 
    public Site getSiteByName(String siteCode);

}