package model;

import java.sql.Time; 
import java.util.Date;

public class DailySchedule {

	private Date date;
	private Time openingTime1;
	private Time closingTime1;
	private Time openingTime2;
	private Time closingTime2;
	private String description;
	
	public DailySchedule() {}
	

	public DailySchedule(Time openingTime1, Time closingTime1, Time openingTime2, Time closingTime2) {
		this.openingTime1 = openingTime1;
		this.closingTime1 = closingTime1;
		this.openingTime2 = openingTime2;
		this.closingTime2 = closingTime2;
	}

	public DailySchedule(Date date, Time openingTime1, Time closingTime1, Time openingTime2, Time closingTime2) {
		this.date = date;
		this.setOpeningTime1(openingTime1);
		this.closingTime1 = closingTime1;
		this.openingTime2 = openingTime2;
		this.closingTime2 = closingTime2;
	}


	public Time getOpeningTime1() {
		return openingTime1;
	}


	public void setOpeningTime1(Time openingTime1) {
		this.openingTime1 = openingTime1;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getClosingTime1() {
		return closingTime1;
	}


	public void setClosingTime1(Time closingTime1) {
		this.closingTime1 = closingTime1;
	}


	public Time getOpeningTime2() {
		return openingTime2;
	}


	public void setOpeningTime2(Time openingTime2) {
		this.openingTime2 = openingTime2;
	}


	public Time getClosingTime2() {
		return closingTime2;
	}


	public void setClosingTime2(Time closingTime2) {
		this.closingTime2 = closingTime2;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
