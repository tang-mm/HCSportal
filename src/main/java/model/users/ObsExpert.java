package model.users;


public class ObsExpert extends User { 
	
	private int level;  // must be 1/2/3
	
	public ObsExpert() {
		super();
	}

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
		case 1:
			this.setUserTypeId(UserTypeEnum.EXPERT_L1.getId());
			break;
		default:
			throw new IllegalArgumentException("Invalid Expert Level value!");
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
 }
