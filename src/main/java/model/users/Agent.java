package model.users;

import model.AgentTeam;

public class Agent extends CustomerSideUser {

	protected AgentTeam team;
	protected boolean isSupervisor = false;
	
	public Agent() {}
  
	
	public Agent(String username, String password, int userTypeId) {
		super(username, password, userTypeId);
	}
}
