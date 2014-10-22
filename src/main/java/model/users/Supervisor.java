package model.users;

public class Supervisor extends Agent {

	public Supervisor() {
		// TODO Auto-generated constructor stub
	}

	public Supervisor(String username, String password) { 
		super(username, password, UserTypeEnum.SUPERVISOR.getId());
		this.isSupervisor = true;
	}

}
