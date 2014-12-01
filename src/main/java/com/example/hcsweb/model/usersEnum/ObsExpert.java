package com.example.hcsweb.model.usersEnum;
 

public class ObsExpert extends User { 
	
	private int level;  // must be 2 or 3 
	public ObsExpert(String username, String password, int level) {	
		super();
		this.setUsername(username);
		this.setPassword(password);
		switch (level) {
		case 3:
			this.setUserTypeId(UserTypeEnum.EXPERT_L3.getId());
			break;
		case 2:
			this.setUserTypeId(UserTypeEnum.EXPERT_L2.getId());
			break; 
		default:
			throw new IllegalArgumentException("Invalid Expert Level value!");
		}
	} 

	public ObsExpert(int level) {
		this.setLevel(level);
	}
 
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	} 
}
