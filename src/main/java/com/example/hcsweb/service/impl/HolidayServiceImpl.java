package com.example.hcsweb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.HolidayDao;
import com.example.hcsweb.model.Holiday;
import com.example.hcsweb.model.Site;
import com.example.hcsweb.service.HolidayService;
import com.example.hcsweb.service.SiteService;

@Service("holidayService")
@Transactional
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayDao holidayDao;

	@Override
	public boolean isHoliday(int siteId, Date date) {
		try {
			this.getHolidayBySiteIdAndDate(siteId, date);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Holiday findHolidayById(int id) throws HibernateException {
		Holiday holiday = holidayDao.getById(id);
		if (holiday == null)
			throw new HibernateException("Holiday not found: id = " + id);
		return holiday;
	}

	@Override
	public Holiday getHolidayBySiteIdAndDate(int siteId, Date date) throws HibernateException {
		Holiday holiday = holidayDao.getHolidayBySiteIdAndDate(siteId, date);
		if (holiday == null)
			throw new HibernateException("Holiday not found: siteId = " + siteId + " Date = " + date.toString());
		return holiday;
	}

	@Override
	public void saveHoliday(Holiday holiday) {
		holidayDao.saveOrUpdate(holiday);
	}

	@Override
	public void deleteHoliday(int id) throws HibernateException {
		holidayDao.delete(id);
	}

	@Override
	public List<Holiday> getAllHolidays() {
		return holidayDao.getAll();
	}

	@Override
	public List<Holiday> findHolidaysByDate(Date date) {
		return holidayDao.findHolidaysByDate(date);
	}

	@Override
	public List<Holiday> findHolidaysBySiteId(int siteId) {
		return holidayDao.findHolidaysBySiteId(siteId);
	}

	@Override
	public List<Holiday> findHolidaysByServiceId(int serviceId) {
		List<Holiday> listH = new ArrayList<Holiday>();
		SiteService siteService = new SiteServiceImpl();
		List<Site> listSite = siteService.findSitesByServiceId(serviceId);
		if (!listSite.isEmpty()) {
			for (Site s : listSite) {
				listH.addAll(holidayDao.findHolidaysBySiteId(s.getSiteId()));
			}
		}
		return listH;
	}

}
