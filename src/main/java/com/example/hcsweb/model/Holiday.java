package com.example.hcsweb.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "holidays")
public class Holiday implements AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3035431207049014015L;
	

	/* ************* Attributes ************ */
	private int holidayId;
	private Date holiday;
	private String description;
	private Site site;


	/* ************* Constructors ************ */
	

	/* ************* Getters and Setters ************ */
	@Id
	@GeneratedValue
	@Column(name = "holiday_id")
	public int getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "holiday")
	public Date getHoliday() {
		return holiday;
	}
	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "site_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
}