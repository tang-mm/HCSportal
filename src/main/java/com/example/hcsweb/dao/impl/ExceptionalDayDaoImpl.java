package com.example.hcsweb.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.ExceptionalDayDao;
import com.example.hcsweb.model.ExceptionalDay;

@Repository("exceptionalDayDao")
public class ExceptionalDayDaoImpl extends AbstractGenericDaoImpl<ExceptionalDay, Integer> implements ExceptionalDayDao {

	@Override
	public ExceptionalDay getExceptionalDayBySiteIdAndDate(int siteId, Date date) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<ExceptionalDay> lst = session
				.createQuery("FROM ExceptionalDay WHERE site_id = :siteId AND holiday = :date ")
				.setParameter("siteId", siteId).setParameter("date", date).list();
		trans.commit();

		return (lst.isEmpty() ? null : lst.get(0));
	}

	@Override
	public List<ExceptionalDay> findExceptionalDaysByDate(Date date) {
		return findByCriteria(null, Restrictions.eq("date", date));
	}

	@Override
	public List<ExceptionalDay> findExceptionalDaysBySiteId(int siteId) {
		return findByCriteria(null, Restrictions.eq("site.siteId", siteId));
	}

}