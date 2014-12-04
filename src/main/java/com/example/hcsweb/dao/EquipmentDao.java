package com.example.hcsweb.dao;

import java.util.List;

import com.example.hcsweb.model.Equipment;

public interface EquipmentDao extends GenericDao<Equipment, Long> {

	// TODO pagination
	public List<Equipment> findEquipmentByTenantId(int tenantId);

	public List<Equipment> searchEquipment(int tenantId, String equipName, String ipAdd, String serialNum,
			String machineType, boolean virtualized, String os, String appVersion, String hardware, String geoLocation);

}