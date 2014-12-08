package com.example.hcsweb.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.WeeklyScheduleDao;
import com.example.hcsweb.model.WeeklySchedule;

@Repository("weeklyScheduleDao")
public class WeeklyScheduleDaoImpl extends AbstractGenericDaoImpl<WeeklySchedule, Integer> implements WeeklyScheduleDao {
 
	public WeeklySchedule findScheduleByName(String name) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<WeeklySchedule> lst = session.createQuery("FROM WeeklySchedule WHERE schedule_name = ? ").setParameter(0, name).list();
		trans.commit();
		
		return (lst.isEmpty() ? null : lst.get(0));
	}
	
	public List<WeeklySchedule> findSchedulesByTenantId(int tenantId) {
		return findByCriteria(null, Restrictions.eq("tenant.tenantId", tenantId));
	}
    
    public List<WeeklySchedule> findSchedulesByCreatedByUserId(int userId) {
		return findByCriteria(null, Restrictions.eq("createdBy.userId", userId));
	}
    
    
}