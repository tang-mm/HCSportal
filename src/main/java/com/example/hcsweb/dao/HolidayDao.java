package com.example.hcsweb.dao;

import java.util.Date;
import java.util.List;

import com.example.hcsweb.model.Holiday;
 

public interface HolidayDao extends GenericDao<Holiday, Integer> {
  
	Holiday getHolidayBySiteIdAndDate(int siteId, Date date);

    List<Holiday> findHolidaysByDate(Date date);
	
	List<Holiday> findHolidaysBySiteId(int siteId);

}