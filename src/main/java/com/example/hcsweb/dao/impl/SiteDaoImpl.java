package com.example.hcsweb.dao.impl;

import java.util.List;

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
 
}