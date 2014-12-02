package com.example.hcsweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location implements AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6183769485920358376L;

	/* ************ Attributes *************/
	private int locationId;
	private String country;
	private String state;
	private String city;
	private String timeZone;
	
	private List<Site> listSite = new ArrayList<Site>();
	
	/* ************ Constructors *************/
	public Location(){}

	public Location(int locationId, String country, String state, String city, String timeZone) {
		super();
		this.locationId = locationId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.timeZone = timeZone;
	}
	
	/* ************ Getters and Setters *************/
	@Id
	@GeneratedValue
	@Column(name = "location_id")
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "time_zone")
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@OneToMany(mappedBy = "location")
	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}

	
}