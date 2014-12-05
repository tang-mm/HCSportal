package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.WeeklySchedule;

public interface WeeklyScheduleService {

	WeeklySchedule findScheduleById(int id) throws HibernateException;

	WeeklySchedule findScheduleByName(String name);

	void saveSchedule(WeeklySchedule schedule);

	void deleteSchedule(int id) throws HibernateException;

	List<WeeklySchedule> getAllSchedules(); 

	List<WeeklySchedule> findSchedulesByTenantId(int tenantId);

	List<WeeklySchedule> findSchedulesByCreatedByUserId(int userId);

}