package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Equipment;
 

public interface EquipmentDao extends GenericDao<Equipment, Integer> {
 
	
	//TODO pagination
	
	public List<Equipment> searchEquipment();
    /*
	public List searchAccommodation(Date startDate, Date endDate, Country country, AccommodationType type, Integer capacity) {
		Criteria criteria = session.createCriteria(Accommodation.class); 
		if (startDate != null) { 
			criteria.add(Expression.ge("availabilityDate", startDate); 
			}
		if (endDate != null) { 
			criteria.add(Expression.le("availabilityDate", endDate); 
		} 
		if (country != null) { 
			criteria.add(Expression.eq("country",country); 
		} 
		if (capacity != null) { 
			criteria.add(Expression.ge("capacity",capacity); 
		} 
		if (type != null) { 
			criteria.add(Expression.eq("type",type); 
		} 
		List results = criteria.list(); // 
		// Execute the query // 
	
		return query.list(); 
	}
//TODO	http://www.devx.com/Java/Article/28754/0/page/2
	*/
}