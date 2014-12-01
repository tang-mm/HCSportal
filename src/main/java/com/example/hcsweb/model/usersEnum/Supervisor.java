package com.example.hcsweb.model.usersEnum;
 

public class Supervisor extends CustomerSideUser {

	protected AgentTeam team; 
	protected String department;

	public Supervisor() {}  
	
	public Supervisor(String username, String password) { 
		super(username, password, UserTypeEnum.SUPERVISOR.getId()); 
	}

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
