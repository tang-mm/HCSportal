package com.example.hcsweb.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.hcsweb.model.users.User;

@Entity
@Table(name="weekly_schedules")
public class WeeklySchedule implements AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3793864699705732920L;
	
	/* *********** Attributes *************/
	private int scheduleId;
	private String scheduleName;
	private String description;
	
	private Tenant tenant;
	private User createdBy;
	private List<Site> listSite = new ArrayList<Site>();
	
	private Time mondayOpen1;
	private Time mondayClose1;
	private Time mondayOpen2;
	private Time mondayClose2;

	private Time tuesdayOpen1;
	private Time tuesdayClose1;
	private Time tuesdayOpen2;
	private Time tuesdayClose2;

	private Time wednesdayOpen1;
	private Time wednesdayClose1;
	private Time wednesdayOpen2;
	private Time wednesdayClose2;

	private Time thursdayOpen1;
	private Time thursdayClose1;
	private Time thursdayOpen2;
	private Time thursdayClose2;

	private Time fridayOpen1;
	private Time fridayClose1;
	private Time fridayOpen2;
	private Time fridayClose2;

	private Time saturdayOpen1;
	private Time saturdayClose1;
	private Time saturdayOpen2;
	private Time saturdayClose2;

	private Time sundayOpen1;
	private Time sundayClose1;
	private Time sundayOpen2;
	private Time sundayClose2;
	
	/* *********** Constructors *************/
	public WeeklySchedule() {}
	
	public WeeklySchedule(int scheduleId, String scheduleName, String description, Tenant tenant, User createdBy) {
		super();
		this.scheduleId = scheduleId;
		this.scheduleName = scheduleName;
		this.description = description;
		this.tenant = tenant;
		this.createdBy = createdBy;
	} 

	/* *********** Getters and Setters *************/
	@Id
	@Column(name = "schedule_id")
	@GeneratedValue
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	@Column(name = "schedule_name")
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "tenant_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "user_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@OneToMany(mappedBy = "schedule")
	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}

	/* ************ Schedule *************/
	@Column(name = "mon_open_1")
	public Time getMondayOpen1() {
		return mondayOpen1;
	}

	public void setMondayOpen1(Time mondayOpen1) {
		this.mondayOpen1 = mondayOpen1;
	}
	
	@Column(name = "mon_close_1")
	public Time getMondayClose1() {
		return mondayClose1;
	}

	public void setMondayClose1(Time mondayClose1) {
		this.mondayClose1 = mondayClose1;
	}
	
	@Column(name = "mon_open_2")
	public Time getMondayOpen2() {
		return mondayOpen2;
	}

	public void setMondayOpen2(Time mondayOpen2) {
		this.mondayOpen2 = mondayOpen2;
	}

	@Column(name = "mon_close_2")
	public Time getMondayClose2() {
		return mondayClose2;
	}

	public void setMondayClose2(Time mondayClose2) {
		this.mondayClose2 = mondayClose2;
	}

	@Column(name = "tue_open_1")
	public Time getTuesdayOpen1() {
		return tuesdayOpen1;
	}

	public void setTuesdayOpen1(Time tuesdayOpen1) {
		this.tuesdayOpen1 = tuesdayOpen1;
	}

	@Column(name = "tue_close_1")
	public Time getTuesdayClose1() {
		return tuesdayClose1;
	}

	public void setTuesdayClose1(Time tuesdayClose1) {
		this.tuesdayClose1 = tuesdayClose1;
	}

	@Column(name = "tue_open_2")
	public Time getTuesdayOpen2() {
		return tuesdayOpen2;
	}

	public void setTuesdayOpen2(Time tuesdayOpen2) {
		this.tuesdayOpen2 = tuesdayOpen2;
	}

	@Column(name = "tue_close_2")
	public Time getTuesdayClose2() {
		return tuesdayClose2;
	}

	public void setTuesdayClose2(Time tuesdayClose2) {
		this.tuesdayClose2 = tuesdayClose2;
	}

	@Column(name = "wed_open_1")
	public Time getWednesdayOpen1() {
		return wednesdayOpen1;
	}

	public void setWednesdayOpen1(Time wednesdayOpen1) {
		this.wednesdayOpen1 = wednesdayOpen1;
	}

	@Column(name = "wed_close_1")
	public Time getWednesdayClose1() {
		return wednesdayClose1;
	}

	public void setWednesdayClose1(Time wednesdayClose1) {
		this.wednesdayClose1 = wednesdayClose1;
	}

	@Column(name = "wed_open_2")
	public Time getWednesdayOpen2() {
		return wednesdayOpen2;
	}

	public void setWednesdayOpen2(Time wednesdayOpen2) {
		this.wednesdayOpen2 = wednesdayOpen2;
	}

	@Column(name = "wed_close_2")
	public Time getWednesdayClose2() {
		return wednesdayClose2;
	}

	public void setWednesdayClose2(Time wednesdayClose2) {
		this.wednesdayClose2 = wednesdayClose2;
	}

	@Column(name = "thu_open_1")
	public Time getThursdayOpen1() {
		return thursdayOpen1;
	}

	public void setThursdayOpen1(Time thursdayOpen1) {
		this.thursdayOpen1 = thursdayOpen1;
	}

	@Column(name = "thu_close_1")
	public Time getThursdayClose1() {
		return thursdayClose1;
	}

	public void setThursdayClose1(Time thursdayClose1) {
		this.thursdayClose1 = thursdayClose1;
	}

	@Column(name = "thu_open_2")
	public Time getThursdayOpen2() {
		return thursdayOpen2;
	}

	public void setThursdayOpen2(Time thursdayOpen2) {
		this.thursdayOpen2 = thursdayOpen2;
	}

	@Column(name = "thu_close_2")
	public Time getThursdayClose2() {
		return thursdayClose2;
	}

	public void setThursdayClose2(Time thursdayClose2) {
		this.thursdayClose2 = thursdayClose2;
	}

	@Column(name = "fri_open_1")
	public Time getFridayOpen1() {
		return fridayOpen1;
	}

	public void setFridayOpen1(Time fridayOpen1) {
		this.fridayOpen1 = fridayOpen1;
	}

	@Column(name = "fri_close_1")
	public Time getFridayClose1() {
		return fridayClose1;
	}

	public void setFridayClose1(Time fridayClose1) {
		this.fridayClose1 = fridayClose1;
	}

	@Column(name = "fri_open_2")
	public Time getFridayOpen2() {
		return fridayOpen2;
	}

	public void setFridayOpen2(Time fridayOpen2) {
		this.fridayOpen2 = fridayOpen2;
	}

	@Column(name = "fri_close_2")
	public Time getFridayClose2() {
		return fridayClose2;
	}

	public void setFridayClose2(Time fridayClose2) {
		this.fridayClose2 = fridayClose2;
	}

	@Column(name = "sat_open_1")
	public Time getSaturdayOpen1() {
		return saturdayOpen1;
	}

	public void setSaturdayOpen1(Time saturdayOpen1) {
		this.saturdayOpen1 = saturdayOpen1;
	}

	@Column(name = "sat_close_1")
	public Time getSaturdayClose1() {
		return saturdayClose1;
	}

	public void setSaturdayClose1(Time saturdayClose1) {
		this.saturdayClose1 = saturdayClose1;
	}

	@Column(name = "sat_open_2")
	public Time getSaturdayOpen2() {
		return saturdayOpen2;
	}

	public void setSaturdayOpen2(Time saturdayOpen2) {
		this.saturdayOpen2 = saturdayOpen2;
	}

	@Column(name = "sat_close_2")
	public Time getSaturdayClose2() {
		return saturdayClose2;
	}

	public void setSaturdayClose2(Time saturdayClose2) {
		this.saturdayClose2 = saturdayClose2;
	}

	@Column(name = "sun_open_1")
	public Time getSundayOpen1() {
		return sundayOpen1;
	}

	public void setSundayOpen1(Time sundayOpen1) {
		this.sundayOpen1 = sundayOpen1;
	}

	@Column(name = "sun_close_1")
	public Time getSundayClose1() {
		return sundayClose1;
	}

	public void setSundayClose1(Time sundayClose1) {
		this.sundayClose1 = sundayClose1;
	}

	@Column(name = "sun_open_2")
	public Time getSundayOpen2() {
		return sundayOpen2;
	}

	public void setSundayOpen2(Time sundayOpen2) {
		this.sundayOpen2 = sundayOpen2;
	}

	@Column(name = "sun_close_2")
	public Time getSundayClose2() {
		return sundayClose2;
	}

	public void setSundayClose2(Time sundayClose2) {
		this.sundayClose2 = sundayClose2;
	}

}
