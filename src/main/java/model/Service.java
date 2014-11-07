package model;

public class Service {
	 
	private int serviceId;
	private String serviceCode;
	private int customerId;
	private String customerName;
	private int locationId;
	private String location;
	private String timeZone;
	private boolean emergency;
	private boolean open;
	
	public Service() { }
	
	public Service(int serviceId, String serviceCode, int customerId, String customerName, String location, String timeZone, boolean emergency, boolean open) { 
		this.serviceId = serviceId;
		this.serviceCode = serviceCode;
		this.customerId = customerId;
		this.customerName = customerName;
		this.location = location;
		this.timeZone = timeZone;
		this.emergency = emergency;
		this.open = open;
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

	public boolean getEmergency() {
		return emergency;
	}

	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}



}