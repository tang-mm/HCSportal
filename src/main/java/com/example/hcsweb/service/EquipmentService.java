package com.example.hcsweb.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.hcsweb.model.Equipment;

public interface EquipmentService {

	Equipment findEquipmentById(int id) throws HibernateException; 

	void saveEquipment(Equipment equip);

	void deleteEquipment(int id) throws HibernateException;

	List<Equipment> getAllEquipment	();

	List<Equipment> findEquipmentByTenantId(int tenantId);

	List<Equipment> searchEquipment(Integer tenantId, String equipName, String ipAdd, String serialNum,
			String machineType, Boolean virtualized, String os, String appVersion, String hardware, String geoLocation);

}