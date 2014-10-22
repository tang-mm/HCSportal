package model.users.noEnum;

public class ObsExpert extends User {
	public ObsExpert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObsExpert(String username, String password, int userTypeId) {
		super(username, password, userTypeId);
		// TODO Auto-generated constructor stub
	}

	private int level; // must be 1/2/3

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