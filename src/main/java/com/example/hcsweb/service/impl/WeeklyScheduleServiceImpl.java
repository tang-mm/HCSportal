package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.WeeklyScheduleDao;
import com.example.hcsweb.model.WeeklySchedule;
import com.example.hcsweb.service.WeeklyScheduleService;

@Service("weeklyScheduleService")
@Transactional
public class WeeklyScheduleServiceImpl implements WeeklyScheduleService {
	@Autowired
	private WeeklyScheduleDao weeklyScheduleDao;

	@Override
	public WeeklySchedule findScheduleById(int id) throws HibernateException {
		WeeklySchedule schedule = weeklyScheduleDao.getById(id);
		if (schedule == null)
			throw new HibernateException("WeeklySchedule not found : id = " + id);
		return schedule;
	}

	@Override
	public WeeklySchedule findScheduleByName(String name) throws HibernateException{
		WeeklySchedule schedule = weeklyScheduleDao.findScheduleByName(name);
		if (schedule == null)
			throw new HibernateException("WeeklySchedule not found : name = " + name);
		return schedule;
	}

	@Override
	public void saveSchedule(WeeklySchedule schedule) {
		weeklyScheduleDao.saveOrUpdate(schedule);
	}

	@Override
	public void deleteSchedule(int id) throws HibernateException {
		weeklyScheduleDao.delete(id);
	}

	@Override
	public List<WeeklySchedule> getAllSchedules() {
		return weeklyScheduleDao.getAll();
	}

	@Override
	public List<WeeklySchedule> findSchedulesByTenantId(int tenantId) {
		return weeklyScheduleDao.findSchedulesByTenantId(tenantId);
	}

	@Override
	public List<WeeklySchedule> findSchedulesByCreatedByUserId(int userId) {
		return weeklyScheduleDao.findSchedulesByCreatedByUserId(userId);
	}
	
	
}
