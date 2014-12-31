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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.hcsweb.model.users.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="sites")
public class Site implements AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1844425884172994344L;

	/* ************* Attributes ************ */
	private int siteId;
	private String siteCode;
	private boolean emergency;
	private String description;

	private Service service;
	private WeeklySchedule schedule;
	private Location location;

	private List<ExceptionalDay> listException = new ArrayList<ExceptionalDay>();
	private List<Holiday> listHoliday = new ArrayList<Holiday>();
	private List<User> listUserAccess = new ArrayList<User>();
	
	/* ************* Constructors ************ */
	public Site() {
	}

	public Site(int siteId, String siteCode, boolean emergency, String description) {
		super();
		this.siteId = siteId;
		this.siteCode = siteCode;
		this.emergency = emergency;
		this.description = description;
	}

	public Site(int siteId, String siteCode, boolean emergency, String description, Service service,
			WeeklySchedule schedule, Location location) {
		super();
		this.siteId = siteId;
		this.siteCode = siteCode;
		this.emergency = emergency;
		this.description = description;
		this.service = service;
		this.schedule = schedule;
		this.location = location;
	}

	/* ************* Getters and Setters ************ */
	@Id
	@Column(name = "site_id")
	@GeneratedValue
	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	@Column(name = "site_code")
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public WeeklySchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(WeeklySchedule schedule) {
		this.schedule = schedule;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@OneToMany(mappedBy = "site")
	public List<ExceptionalDay> getListException() {
		return listException;
	}

	public void setListException(List<ExceptionalDay> listException) {
		this.listException = listException;
	}

	@OneToMany(mappedBy = "site")
	public List<Holiday> getListHoliday() {
		return listHoliday;
	}

	public void setListHoliday(List<Holiday> listHoliday) {
		this.listHoliday = listHoliday;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listSite")
	public List<User> getListUserAccess() {
		return listUserAccess;
	}

	public void setListUserAccess(List<User> listUserAccess) {
		this.listUserAccess = listUserAccess;
	}
}
