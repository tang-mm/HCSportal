package model;

public class Service {
	 
	private int serviceId;
	private String serviceCode;
	private int customerId;
	private String customerName;
	private int locationId;
	private String location;
	private boolean isInEmergency;
	private boolean isOpen;
	
	public Service() { }
	
	public Service(int serviceId, String serviceCode, int customerId, String customerName, int locationId,
			String location, boolean isInEmergency, boolean isOpen) { 
		this.serviceId = serviceId;
		this.serviceCode = serviceCode;
		this.customerId = customerId;
		this.customerName = customerName;
		this.locationId = locationId;
		this.location = location;
		this.isInEmergency = isInEmergency;
		this.isOpen = isOpen;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isInEmergency() {
		return isInEmergency;
	}

	public void setInEmergency(boolean isInEmergency) {
		this.isInEmergency = isInEmergency;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}



}