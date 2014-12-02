package com.example.hcsweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.example.hcsweb.dao.GenericDao;
 
public abstract class AbstractGenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>  {

	/* ************** Attributes *****************/
	protected Class<T> entityClass;

	@Autowired
	private SessionFactory sessionFactory;

	/* ************** Constructors *****************/
    @SuppressWarnings("unchecked")
	public AbstractGenericDaoImpl(String tableName) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

	/* ************** Getters and Setters *****************/
    public Class<T> getType() {
        return entityClass;
    }	
  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 

	/* ************** Methods *****************/
	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
//		Object obj = getSessionFactory().getCurrentSession().get(getType(),id);
		Session session =getSessionFactory().getCurrentSession(); 
		Transaction trans= session.beginTransaction();
		Object obj = session.get(getType(),id);
		if (obj == null) {
            throw new ObjectRetrievalFailureException(getType(), id);	//TODO Category.class
        }
		trans.commit();
        return (T) obj; 
	}

	@Override
//	@Transactional
	public void saveOrUpdate(T obj) {
//		 getSessionFactory().getCurrentSession().saveOrUpdate(obj);
		 
			Session session =getSessionFactory().getCurrentSession(); 
			Transaction trans= session.beginTransaction();
		   session.saveOrUpdate(obj);
		   trans.commit();
	}

	@Override
	public void delete(PK id) {
//		getSessionFactory().getCurrentSession().delete(getById(id));

		Session session =getSessionFactory().getCurrentSession(); 
		Transaction trans= session.beginTransaction();
		session.delete(getById(id));
		trans.commit();
	}	
	
	@Override
	public List<T> getAll() {
//		List<T> lst = getSessionFactory().getCurrentSession().createQuery("from " + getType().getName()).list(); 

		Session session =getSessionFactory().getCurrentSession(); 
		Transaction trans= session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> lst = session.createQuery("from " + getType().getName()).list();
		trans.commit();
		return lst;
	}
	
}
