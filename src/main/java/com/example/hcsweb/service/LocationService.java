package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Location;

public interface LocationService {

	Location findLocationById(int id) throws HibernateException;

	public List<Location> findLocationsByCityStateCountry(String city, String state, String country)
			throws HibernateException;

	public List<Location> findLocationsByTimeZone(String timeZone);

	void saveLocation(Location loc);

	void deleteLocation(int id) throws HibernateException;

	List<Location> getAllLocations();

}