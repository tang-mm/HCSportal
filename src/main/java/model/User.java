package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	public User() {
	}

	@NotNull
	private String username;
	
	@NotNull @Size(min=6, max=20)
	private String password;

	@NotNull
	private String userType;
	
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
