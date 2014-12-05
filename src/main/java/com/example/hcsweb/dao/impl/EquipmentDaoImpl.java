package com.example.hcsweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.hcsweb.dao.EquipmentDao;
import com.example.hcsweb.model.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl extends AbstractGenericDaoImpl<Equipment, Integer> implements EquipmentDao {

	@Override
	public List<Equipment> findEquipmentByTenantId(int tenantId) {
		return findByCriteria(null, Restrictions.eq("tenant.tenantId", tenantId));
	}

	@Override
	public List<Equipment> searchEquipment(Integer tenantId, String equipName, String ipAddr, String serialNum,
			String machineType, Boolean virtualized, String os, String appVersion, String hardware, String geoLocation) {

		List<Criterion> listCrt = new ArrayList<Criterion>();
		if(tenantId != null) {
			listCrt.add(Restrictions.eq("tenant.tenantId", tenantId.intValue()));
		}
		if(equipName != null) {	// begin with
			listCrt.add(Restrictions.like("equipmentName", equipName, MatchMode.START));
		}
		if(ipAddr != null) {
			listCrt.add(Restrictions.eq("ipAddress", ipAddr));
		}
		if(serialNum != null) {	// begin with
			listCrt.add(Restrictions.like("serialNumber", serialNum, MatchMode.START));
		}
		if(machineType != null) {
			listCrt.add(Restrictions.eq("machineType", machineType));
		}
		if(virtualized != null) {
			listCrt.add(Restrictions.eq("isVirtualized", virtualized.booleanValue()));
		}
		if(os != null) {
			listCrt.add(Restrictions.eq("operatingSystem", os));
		}
		if(appVersion != null) {
			listCrt.add(Restrictions.eq("appVersion", appVersion));
		}
		if(hardware != null) {
			listCrt.add(Restrictions.eq("hardware", hardware));
		}
		if(geoLocation != null) {
			listCrt.add(Restrictions.eq("geoLocation", geoLocation));
		}

		Criterion[] arrayCrt = new Criterion[listCrt.size()];
		return findByCriteria(null, arrayCrt);
	}
}
