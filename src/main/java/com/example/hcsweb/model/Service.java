package com.example.hcsweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.hcsweb.model.users.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="services")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class Service implements AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4708942493854084590L;

	/* **************** Attributes **************** */
	private int serviceId;
	private String serviceCode;
	private boolean emergency;
	private boolean open;
	// private String location;
	// private String timeZone;
	private String description;
	private List<Site> listSite = new ArrayList<Site>();
	// TODO PIN code + audio

	private List<User> listUserAccess = new ArrayList<User>();
	private Tenant tenant;

	/* **************** Constructors **************** */
	public Service() {
	}

	public Service(int serviceId, String serviceCode, Tenant tenant, boolean emergency, String description) {
		this.serviceId = serviceId;
		this.serviceCode = serviceCode;
		this.tenant = tenant;
		this.emergency = emergency;
		this.description = description;
	}

	/* **************** Getters and Setters **************** */
	@Id
	@Column(name = "service_id")
	@GeneratedValue
	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "service_code")
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
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

	@Column(name = "emergency")
	public boolean getEmergency() {
		return emergency;
	}

	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "service")
	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	
	@ManyToMany(mappedBy = "listService")
	public List<User> getListUserAccess() {
		return listUserAccess;
	}

	public void setListUserAccess(List<User> listUserAccess) {
		this.listUserAccess = listUserAccess;
	}
	/* ******* not mapped *********** */
	@Transient
	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	//@Transient
	//public String getLocation() {
	// return location;
	// }
	//
	// public void setLocation(String location) {
	// this.location = location;
	// }
	// @Transient
	// public String getTimeZone() {
	// return timeZone;
	// }
	//
	// public void setTimeZone(String timeZone) {
	// this.timeZone = timeZone;
	// }

}