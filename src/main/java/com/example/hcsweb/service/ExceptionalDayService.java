package com.example.hcsweb.service;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.ExceptionalDay;

public interface ExceptionalDayService {

	boolean isExceptionalDay(int siteId, Date date); 

	ExceptionalDay getExceptionalDayById(int id) throws HibernateException;
	ExceptionalDay getExceptionalDayBySiteIdAndDate(int siteId, Date date) throws HibernateException;
	void saveExceptionalDay(ExceptionalDay holiday);

	void deleteExceptionalDay(int id) throws HibernateException;

	List<ExceptionalDay> getAllExceptionalDays();


	List<ExceptionalDay> findExceptionalDaysByDate(Date date);

	List<ExceptionalDay> findExceptionalDaysBySiteId(int siteId);
	List<ExceptionalDay> findExceptionalDaysByServiceId(int serviceId);

}