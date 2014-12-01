package com.example.hcsweb.model;

import java.sql.Time;
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
@Table(name = "exceptional_day")
public class ExceptionalDay implements AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4348145114445827130L;
	
	/* ************ Attributes *************/
	private int exceptionalDayId;
	private Date date;
	private Time openingTime1;
	private Time closingTime1;
	private Time openingTime2;
	private Time closingTime2;
	private String description;
	
	private Site site;

	/* ************ Constructors *************/
	public ExceptionalDay() {}
	

	public ExceptionalDay(Time openingTime1, Time closingTime1, Time openingTime2, Time closingTime2) {
		this.openingTime1 = openingTime1;
		this.closingTime1 = closingTime1;
		this.openingTime2 = openingTime2;
		this.closingTime2 = closingTime2;
	}

	public ExceptionalDay(Date date, Time openingTime1, Time closingTime1, Time openingTime2, Time closingTime2) {
		this.date = date;
		this.setOpeningTime1(openingTime1);
		this.closingTime1 = closingTime1;
		this.openingTime2 = openingTime2;
		this.closingTime2 = closingTime2;
	}
 

	/* ************ Getters and Setters *************/
	@Id
	@GeneratedValue
	@Column(name = "exception_id")
	public int getExceptionalDayId() {
		return exceptionalDayId;
	}


	public void setExceptionalDayId(int exceptionalDayId) {
		this.exceptionalDayId = exceptionalDayId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "exception_date")
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "open_time_1")
	public Time getOpeningTime1() {
		return openingTime1;
	}

	public void setOpeningTime1(Time openingTime1) {
		this.openingTime1 = openingTime1;
	}

	@Column(name = "close_time_1")
	public Time getClosingTime1() {
		return closingTime1;
	}

	public void setClosingTime1(Time closingTime1) {
		this.closingTime1 = closingTime1;
	}

	@Column(name = "open_time_2")
	public Time getOpeningTime2() {
		return openingTime2;
	}
 
	public void setOpeningTime2(Time openingTime2) {
		this.openingTime2 = openingTime2;
	}

	@Column(name = "close_time_2")
	public Time getClosingTime2() {
		return closingTime2;
	}

	public void setClosingTime2(Time closingTime2) {
		this.closingTime2 = closingTime2;
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
