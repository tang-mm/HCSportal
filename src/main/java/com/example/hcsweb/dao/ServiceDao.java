package com.example.hcsweb.dao;

import com.example.hcsweb.model.Service;
 

public interface ServiceDao extends GenericDao<Service, Integer> {
 
    public Service getServiceByName(String code);
}