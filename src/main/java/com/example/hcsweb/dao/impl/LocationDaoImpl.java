package com.example.hcsweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.LocationDao;
import com.example.hcsweb.model.Location;

@Repository("locationDao")
public class LocationDaoImpl extends AbstractGenericDaoImpl<Location, Integer> implements LocationDao {
 
	@Override
	public List<Location> findLocationsByCityStateCountry(String city, String state, String country) {
		List<Criterion> listCri = new ArrayList<Criterion>();
		if (city != null) {
			listCri.add(Restrictions.eq("city", city));
		}
		if (state != null) {
			listCri.add(Restrictions.eq("state", state));
		}
		if (country != null) {
			listCri.add(Restrictions.eq("country", country));
		}
		Criterion[] arrayCri = new Criterion[listCri.size()];
		return findByCriteria(null, arrayCri);
	}

	@Override
	public List<Location> findLocationsByTimeZone(String timeZone) {
		return findByCriteria(null, Restrictions.eq("timeZone", timeZone));
	}

}
