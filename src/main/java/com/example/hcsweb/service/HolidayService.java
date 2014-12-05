package com.example.hcsweb.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Holiday;

public interface HolidayService {
	
	boolean isHoliday(int siteId, Date date);

	Holiday findHolidayById(int id) throws HibernateException;

	Holiday getHolidayBySiteIdAndDate(int siteId, Date date);

	void saveHoliday(Holiday holiday);

	void deleteHoliday(int id) throws HibernateException;

	List<Holiday> getAllHolidays();

	List<Holiday> findHolidaysByDate(Date date);

	List<Holiday> findHolidaysBySiteId(int siteId);

	List<Holiday> findHolidaysByServiceId(int serviceId);
	
}