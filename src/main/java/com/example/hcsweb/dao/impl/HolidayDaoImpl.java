package com.example.hcsweb.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.HolidayDao;
import com.example.hcsweb.model.Holiday;

@Repository("holidayDao")
public class HolidayDaoImpl extends AbstractGenericDaoImpl<Holiday, Integer> implements HolidayDao {

	@Override
	public Holiday getHolidayBySiteIdAndDate(int siteId, Date date) {
		@SuppressWarnings("unchecked")
		List<Holiday> lst = getSession().createQuery("FROM Holiday WHERE site_id = :siteId AND holiday = :date ")
				.setParameter("siteId", siteId).setParameter("date", date).list();
		return (lst.isEmpty() ? null : lst.get(0));
	}

	@Override
	public List<Holiday> findHolidaysByDate(Date date) {
		return findByCriteria(null, Restrictions.eq("holiday", date));
	}

	@Override
	public List<Holiday> findHolidaysBySiteId(int siteId) {
		return findByCriteria(null, Restrictions.eq("site.siteId", siteId));
	}

}