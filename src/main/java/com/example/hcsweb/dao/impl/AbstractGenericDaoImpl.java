package com.example.hcsweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.GenericDao;

@Repository
public abstract class AbstractGenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	/* ************** Attributes **************** */
	protected Class<T> entityClass;

	private SessionFactory sessionFactory;

	/* ************** Constructors **************** */
	@SuppressWarnings("unchecked")
	public AbstractGenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	/* ************** Getters and Setters **************** */
	public Class<T> getType() {
		return entityClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
//		 return getSessionFactory().openSession();
	} 
	

	/* ************** Methods **************** */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T getById(PK id) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		Object obj = session.get(getType(), id);
		trans.commit();
		
		if (obj == null) {
			throw new ObjectRetrievalFailureException(getType(), id);
		}
		return (T) obj;
	}

	@Override
	@Transactional
	public void saveOrUpdate(T obj) {
		// use merge() to avoid NonUniqueObjectException
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		getSession().saveOrUpdate(obj);
		// getSession().merge(obj);
		trans.commit();
	}

	@Override
	@Transactional
	public void delete(PK id) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		getSession().delete(getById(id)); 

		trans.commit();
	}

	@Override
	@Transactional
	public List<T> getAll() {
//		@SuppressWarnings("unchecked") 
//		List<T> lst = getSession().createQuery("from " + getType().getName()).list();
//
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<T> lst = session.createQuery("from " + getType().getName()).list();
		
		trans.commit();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> findByCriteria(HashMap<String, String> aliases, Criterion... criterionArray) {
		if (criterionArray == null || criterionArray.length == 0) {
			return null;
		}

		Session session = getSession();
		Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(entityClass);
		
		for (Criterion cri : criterionArray) {
			criteria.add(cri);
		}
		if (aliases != null) {
			for (Entry<String, String> entry : aliases.entrySet()) {
				criteria.createAlias(entry.getKey(), entry.getValue());
			}
		}
		List<T> list = criteria.list();
		trans.commit();
		return list;
	}
}
