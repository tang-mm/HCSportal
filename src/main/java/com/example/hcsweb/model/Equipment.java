package com.example.hcsweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name ="equipment") 
public class Equipment implements AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6114585422978045445L;
	/* ************ Attributes *************/
	private int equipmentId;
	private String equipmentName;
	private String ipAddress;
	private String serialNumber;
	private String machineType;
	private boolean isVirtualized;
	private String operatingSystem;
	private String appVersion;
	private String hardware;
	private String geoLocation;
	private String description;

	private Tenant tenant;
	/* ************ Constructors *************/
	public Equipment() {}

	public Equipment(int equipmentId, String name, String ipAddress, String serialNumber,
			String machineType, boolean isVirtualized, String operatingSystem, String appVersion, String hardware, String geoLocation) {
		this.equipmentId = equipmentId; 
		this.equipmentName = name;
		this.ipAddress = ipAddress;
		this.serialNumber = serialNumber;
		this.machineType = machineType;
		this.isVirtualized = isVirtualized;
		this.operatingSystem = operatingSystem;
		this.appVersion = appVersion;
		this.hardware = hardware;
		this.geoLocation = geoLocation;
	}

	/* ************ Getters and Setters *************/
	@Id
	@GeneratedValue
	@Column(name = "equipment_id")
	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenant_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	@Column(name = "equipment_name")
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "ip_address")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	@Column(name = "serial_number")
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Column(name = "machine_type")
	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	@Column(name = "is_virtualized")
	public boolean getIsVirtualized() {
		return isVirtualized;
	}

	public void setIsVirtualized(boolean isVirtualized) {
		this.isVirtualized = isVirtualized;
	}

	@Column(name = "operating_system")
	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	@Column(name = "app_version")
	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	@Column(name = "hardware")
	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	@Column(name = "geo_location")
	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
