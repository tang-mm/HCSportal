package com.example.hcsweb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.example.hcsweb.dao.GenericDao;
import com.example.hcsweb.model.AbstractBean;
 
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>  {

	protected Class<T> entityClass;
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public Class<T> getType() {
        return entityClass;
    }	
 
    
	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
		Object obj = getSessionFactory().getCurrentSession().get(getType(),id);
        if (obj == null) {
            throw new ObjectRetrievalFailureException(AbstractBean.class, id);	//TODO Category.class
        }
        return (T) obj; 
	}

	@Override
	public void saveOrUpdate(T obj) {
		 getSessionFactory().getCurrentSession().saveOrUpdate(obj);
	}

	@Override
	public void delete(PK id) {
		getSessionFactory().getCurrentSession().delete(getById(id));
	}	
	
	@Override
	public List<T> getAll() {
		@SuppressWarnings("unchecked")
		List<T> lst = getSessionFactory().getCurrentSession().createQuery("from " + getType().getName()).list();
		return lst;
	}
	
	
}
