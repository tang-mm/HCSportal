package model.users.inEnum;


public class User {

//	@NotNull
	protected String username;
//	@NotNull @Size(min=6, max=20)
	protected String password;
//	@NotNull
	protected int userTypeId;
//	@NotNull
	protected UserTypeEnum userType;	// cannot be set directly, must be combined with userTypeId

	protected String lastLogin;
	protected String domainName;
	
	public User() {
	}

	public User(String username, String password, int userTypeId){ 
		this.username = username;
		this.password = password;
		this.userTypeId = userTypeId;
		this.updateUserType(userTypeId);
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

	/**
	 * update both userTypeId and userType
	 * @param userTypeId
	 */
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
		this.updateUserType(userTypeId);
	}
	
	public UserTypeEnum getUserTypeAsEnum() {
		return userType;
	}
	
	public String getUserTypeAsString() {
		return userType.getType();
	}

	/**
	 * Cannot modify UserType directly 
	 * @param userType
	 */
	protected void updateUserType(int userTypeId) {
		this.userType = UserTypeEnum.getEnumById(userTypeId);
	} 
	
}
