package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Equipment;

public interface EquipmentDao extends GenericDao<Equipment, Integer> {

	// TODO pagination
	public List<Equipment> findEquipmentByTenantId(int tenantId);

	public List<Equipment> searchEquipment(Integer tenantId, String equipName, String ipAdd, String serialNum,
			String machineType, Boolean virtualized, String os, String appVersion, String hardware, String geoLocation);

}