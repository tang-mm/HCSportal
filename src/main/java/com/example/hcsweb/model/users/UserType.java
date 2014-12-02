package com.example.hcsweb.model.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hcsweb.model.AbstractBean;
import com.example.hcsweb.model.users.User;

@Entity
@Table(name = "user_types")
public class UserType implements AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5909374121543310670L;
	/* ************ Attributes *************/
	private int userTypeId;
	private String userType;
	
	private List<User> listUser = new ArrayList<User>();

	/* ************ Constructors *************/
	public UserType() {}
	
	public UserType(int userTypeId, String userType) {
		super();
		this.userTypeId = userTypeId;
		this.userType = userType;
	}

	/* ************ Getters and Setters *************/
	@Id
	@GeneratedValue
	@Column(name = "user_type_id")
	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Column(name = "user_type")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@OneToMany(mappedBy = "userType")
	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	
}