package model;

public class Equipment {

	private int equipmentId;
	private int customerId;
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
	
	public Equipment() {}

	public Equipment(int equipmentId, int customerId, String name, String ipAddress, String serialNumber,
			String machineType, boolean isVirtualized, String operatingSystem, String appVersion, String hardware, String geoLocation) {
		this.equipmentId = equipmentId;
		this.customerId = customerId;
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

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public boolean getIsVirtualized() {
		return isVirtualized;
	}

	public void setIsVirtualized(boolean isVirtualized) {
		this.isVirtualized = isVirtualized;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
