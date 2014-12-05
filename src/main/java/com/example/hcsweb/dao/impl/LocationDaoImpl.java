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
		List<Criterion> listCrt = new ArrayList<Criterion>();
		if (city != null) {
			listCrt.add(Restrictions.eq("city", city));
		}
		if (state != null) {
			listCrt.add(Restrictions.eq("state", state));
		}
		if (country != null) {
			listCrt.add(Restrictions.eq("country", country));
		}
		Criterion[] arrayCrt = new Criterion[listCrt.size()];
		return findByCriteria(null, arrayCrt);
	}

	@Override
	public List<Location> findLocationsByTimeZone(String timeZone) {
		return findByCriteria(null, Restrictions.eq("timeZone", timeZone));
	}

}
