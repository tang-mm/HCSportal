package com.example.hcsweb.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.EquipmentDao;
import com.example.hcsweb.model.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl extends AbstractGenericDaoImpl<Equipment, Long> implements EquipmentDao {

	@Override
	public List<Equipment> findEquipmentByTenantId(int tenantId) {
		return findByCriteria(null, Restrictions.eq("tenant.tenantId", tenantId));
	}

	@Override
	public List<Equipment> searchEquipment(int tenantId, String equipName, String ipAdd, String serialNum,
			String machineType, boolean virtualized, String os, String appVersion, String hardware, String geoLocation) {
		//TODO multi-criteria
		
		return null;
	}

}
