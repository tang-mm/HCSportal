package model.users.noEnum;

public class User {
//	@NotNull
	private String username;
// @NotNull Size(min = 6, max = 20)
	private String password;
//	@NotNull
	private int userTypeId;

	public User() {
	}

	public User(String username, String password, int userTypeId) {
		this.username = username;
		this.password = password;
		this.userTypeId = userTypeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
}