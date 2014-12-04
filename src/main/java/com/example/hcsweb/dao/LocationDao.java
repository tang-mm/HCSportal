package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Location;
 

public interface LocationDao extends GenericDao<Location, Integer> {
 
	public List<Location> findLocationsByCityStateCountry(String city, String state, String country);
	
	public List<Location> findLocationsByTimeZone(String timeZone);
	
}