package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.LocationDao;
import com.example.hcsweb.model.Location;
import com.example.hcsweb.service.LocationService;

@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@Override
	public Location findLocationById(int id) throws HibernateException {
		return locationDao.getById(id);
	}

	@Override
	public List<Location> findLocationsByCityStateCountry(String city, String state, String country)
			throws HibernateException {
		List<Location> list = locationDao.findLocationsByCityStateCountry(city, state, country);
		if (list != null)
			throw new HibernateException("Location not found");
		return list;
	}

	@Override
	public List<Location> findLocationsByTimeZone(String timeZone) {
		return locationDao.findLocationsByTimeZone(timeZone);
	}

	@Override
	public void saveLocation(Location loc) {
		locationDao.saveOrUpdate(loc);
	}

	@Override
	public void deleteLocation(int id) throws HibernateException {
		locationDao.delete(id);
	}

	@Override
	public List<Location> getAllLocations() {
		return locationDao.getAll();
	}

}
