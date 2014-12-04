package com.example.hcsweb.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * generic template for DAO classes
 * @author TangMM
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDao <T, PK extends Serializable> {
	
    public T getById(PK id);
    public void saveOrUpdate(T object);
    public void delete(PK Id);
    public List<T> getAll();

    public List<T> findByCriteria(HashMap<String, String> aliases, Criterion... criterionList);
}
