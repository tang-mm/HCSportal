package com.example.hcsweb.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.EquipmentDao;
import com.example.hcsweb.model.Equipment;
import com.example.hcsweb.service.EquipmentService;

@Service("equipmentService")
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao equipmentDao;

	@Override
	public Equipment findEquipmentById(int id) throws HibernateException {
		Equipment equip = equipmentDao.getById(id);
		if (equip == null)
			throw new HibernateException("Equipment not found: id = " + id);
		return equip;
	}

	@Override
	public void saveEquipment(Equipment equip) {
		equipmentDao.saveOrUpdate(equip);
	}

	@Override
	public void deleteEquipment(int id) throws HibernateException {
		equipmentDao.delete(id);
	}

	@Override
	public List<Equipment> getAllEquipment() {
		return equipmentDao.getAll();
	}

	@Override
	public List<Equipment> findEquipmentByTenantId(int tenantId) {
		return equipmentDao.findEquipmentByTenantId(tenantId);
	}

	@Override
	public List<Equipment> searchEquipment(Integer tenantId, String equipName, String ipAdd, String serialNum,
			String machineType, Boolean virtualized, String os, String appVersion, String hardware, String geoLocation) {
		return equipmentDao.searchEquipment(tenantId, equipName, ipAdd, serialNum, machineType, virtualized, os,
				appVersion, hardware, geoLocation);
	}

}
