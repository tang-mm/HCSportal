package com.example.hcsweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.GenericDao;

@Transactional
public abstract class AbstractGenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>  {

	/* ************** Attributes *****************/
	protected Class<T> entityClass;

	private SessionFactory sessionFactory;

	/* ************** Constructors *****************/
    @SuppressWarnings("unchecked")
	public AbstractGenericDaoImpl() {
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

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 
	
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
//		return getSessionFactory().openSession();
	}
	
	/**
	 * create a Criteria entity in current session
	 * @return
	 */
	public Criteria getCriteria() {
		return  getSession().createCriteria(entityClass);
	}
	
	/* ************** Methods *****************/
	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
		Object obj = getSession().get(getType(),id);
		if (obj == null) {
            throw new ObjectRetrievalFailureException(getType(), id);
        }
        return (T) obj; 
	} 
    
	@Override
	public void saveOrUpdate(T obj) {
		// use merge() to avoid NonUniqueObjectException
		 getSession().saveOrUpdate(obj);   
//		getSession().merge(obj);
	}

	@Override
	public void delete(PK id) {
		getSession().delete(getById(id));

//		Session session =getSessionFactory().getCurrentSession(); 
//		Transaction trans= session.beginTransaction();
//		session.delete(getById(id));
//		trans.commit();
	}	
	
	@Override
	public List<T> getAll() {
		@SuppressWarnings("unchecked")
		List<T> lst = getSession().createQuery("from " + getType().getName()).list(); 

//		Session session =getSessionFactory().getCurrentSession(); 
//		Transaction trans= session.beginTransaction();
//		List<T> lst = session.createQuery("from " + getType().getName()).list();
//		trans.commit();
		return lst;
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<T> findByCriteria(HashMap<String, String> aliases, Criterion... criterionList) {
		Criteria criteria = getCriteria();
		for (Criterion cri : criterionList) {
			criteria.add(cri);
		}
		for (Entry<String, String> entry : aliases.entrySet()){
		    criteria.createAlias(entry.getKey(), entry.getValue());
		}
		
		return criteria.list();
	}
}
