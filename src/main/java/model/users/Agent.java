package model.users;

import model.AgentTeam;

public class Agent extends CustomerSideUser {

	private AgentTeam team;
	
	public Agent() {
		// TODO Auto-generated constructor stub
	}

	public Agent(String username, String password, int userTypeId) { 
		super(username, password, userTypeId);
	}

}
