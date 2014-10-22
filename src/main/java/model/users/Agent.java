package model.users;

import model.AgentTeam;

public class Agent extends CustomerSideUser {

	protected AgentTeam team;
	protected boolean isSupervisor = false;
	
	public Agent() {}
 
	// called by supervisor's constructor
	protected Agent(String username, String password, int userTypeId) {
		super(username, password, userTypeId);
	}
	
	public Agent(String username, String password) { 
		super(username, password, UserTypeEnum.AGENT.getId()); 
	}

}
