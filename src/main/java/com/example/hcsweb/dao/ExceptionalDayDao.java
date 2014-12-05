package com.example.hcsweb.dao;

import java.util.Date;
import java.util.List;

import com.example.hcsweb.model.ExceptionalDay;
 

public interface ExceptionalDayDao extends GenericDao<ExceptionalDay, Integer> {

	ExceptionalDay getExceptionalDayBySiteIdAndDate(int siteId, Date date);

    List<ExceptionalDay> findExceptionalDaysByDate(Date date);
	
	List<ExceptionalDay> findExceptionalDaysBySiteId(int siteId);

    
}