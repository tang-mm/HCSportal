package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.WeeklySchedule;
 

public interface WeeklyScheduleDao extends GenericDao<WeeklySchedule, Integer> {
 
    WeeklySchedule findScheduleByName(String name);
	
	List<WeeklySchedule> findSchedulesByTenantId(int tenantId);
    
    List<WeeklySchedule> findSchedulesByCreatedByUserId(int userId);
    
    
}