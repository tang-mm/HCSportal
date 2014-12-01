package com.example.hcsweb.dao;

import java.io.Serializable;
import java.util.List;

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

}