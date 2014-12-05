package com.example.hcsweb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.ExceptionalDayDao;
import com.example.hcsweb.model.ExceptionalDay;
import com.example.hcsweb.model.Site;
import com.example.hcsweb.service.ExceptionalDayService;
import com.example.hcsweb.service.SiteService;

@Service("exceptionalDayService")
@Transactional
public class ExceptionalDayServiceImpl implements ExceptionalDayService {

	@Autowired
	private ExceptionalDayDao exceptionalDayDao;
	
	@Override
	public boolean isExceptionalDay(int siteId, Date date) {
		try {
			this.getExceptionalDayBySiteIdAndDate(siteId, date);
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 

	@Override
	public ExceptionalDay getExceptionalDayById(int id) throws HibernateException {
		ExceptionalDay day = exceptionalDayDao.getById(id);
		if (day == null)
			throw new HibernateException("ExceptionalDay not found: id = " + id);
		return day;
	}

	@Override
	public ExceptionalDay getExceptionalDayBySiteIdAndDate(int siteId, Date date) throws HibernateException {
		ExceptionalDay day = exceptionalDayDao.getExceptionalDayBySiteIdAndDate(siteId, date);
		if (day == null)
			throw new HibernateException("ExceptionalDay not found: siteId = " + siteId + " Date = " + date.toString());
		return day;
	}

	@Override
	public void saveExceptionalDay(ExceptionalDay exceptionalDay) {
		exceptionalDayDao.saveOrUpdate(exceptionalDay);
	}

	@Override
	public void deleteExceptionalDay(int id) throws HibernateException {
		exceptionalDayDao.delete(id);
	}

	@Override
	public List<ExceptionalDay> getAllExceptionalDays(){
		return exceptionalDayDao.getAll();
	}

	@Override
	public List<ExceptionalDay> findExceptionalDaysByDate(Date date) {
		return exceptionalDayDao.findExceptionalDaysByDate(date);
	}

	@Override
	public List<ExceptionalDay> findExceptionalDaysBySiteId(int siteId) {
		return exceptionalDayDao.findExceptionalDaysBySiteId(siteId);
	}

	@Override
	public List<ExceptionalDay> findExceptionalDaysByServiceId(int serviceId) {
		List<ExceptionalDay> listH = new ArrayList<ExceptionalDay>();
		SiteService siteService = new SiteServiceImpl();
		List<Site> listSite = siteService.findSitesByServiceId(serviceId);
		if (!listSite.isEmpty()) {
			for (Site s : listSite) {
				listH.addAll(exceptionalDayDao.findExceptionalDaysBySiteId(s.getSiteId()));
			}
		}
		return listH;
	}

}
