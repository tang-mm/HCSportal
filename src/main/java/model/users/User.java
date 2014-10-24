package model.users;
 
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.ArrayOfNameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.ObjectFactory;
import com.exony.schemas._2009._10.resourcemanagement.RequestResult;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

public class User {

	@NotNull
	@NotBlank
	protected String username;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 18)
	protected String password;
	@NotNull
	protected String confirmedPassword;
	@NotNull
	protected int userTypeId;
	@NotNull
	protected UserTypeEnum userType; // cannot be set directly, must be combined
										// with userTypeId

	protected String lastLogin;
	protected String domainName;


	public User() {
	}

	public User(String username, String password, int userTypeId) {
		this.username = username;
		this.password = password;
		this.userTypeId = userTypeId;
		this.updateUserType(userTypeId);
	}

	/**
	 * create a new NameValuePair with the given parameters and add it into
	 * array
	 * 
	 * @param array
	 * @param name
	 * @param value
	 * @return
	 */
	public static ArrayOfNameValuePair addNameValuePairCCDMResource(ArrayOfNameValuePair array, String name,
			String value) {
		NameValuePair pair = new NameValuePair();
		pair.setName(name);
		pair.setValue(value);
		array.getNameValuePair().add(pair);

		return array;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
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
	 * 
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
	 * 
	 * @param userType
	 */
	protected void updateUserType(int userTypeId) {
		this.userType = UserTypeEnum.getEnumById(userTypeId);
	}

} 