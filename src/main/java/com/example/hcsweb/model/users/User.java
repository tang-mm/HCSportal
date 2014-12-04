package com.example.hcsweb.model.users;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

import com.example.hcsweb.model.AbstractBean;
import com.example.hcsweb.model.Customer;
import com.example.hcsweb.model.Service;
import com.example.hcsweb.model.Site;
import com.example.hcsweb.model.Tenant;

@Entity
@Table(name = "users")
public class User implements AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4957731325449771335L;
	/* ************ Attributes ************ */
	protected int userId;
	@NotNull
	@NotBlank
	protected String username;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 18)
	protected String password;
	protected String confirmedPassword;
	@NotNull
	protected UserType userType;
	protected Customer customer;
	protected User createdBy;

	protected boolean enabled;
	protected Timestamp creationTime;
	protected Timestamp lastLoggedIn;

	protected String firstName;
	protected String lastName;

	private List<Tenant> listTenant = new ArrayList<Tenant>();
	private List<Service> listService = new ArrayList<Service>();
	private List<Site> listSite = new ArrayList<Site>();

	// protected List<User> listUserCreated = new ArrayList<User>();
	// protected List<WeeklySchedule> listScheduleCreated = new
	// ArrayList<WeeklySchedule>();

	/* ************ Constructors ************ */
	public User() {
	}

	public User(String username, String password, UserType userType, boolean enabled) {
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.enabled = enabled;
	}

	/* ************ Getters and Setters ************ */
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_type_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "created_by")
	@LazyCollection(LazyCollectionOption.TRUE)
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "creation_time")
	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	@Column(name = "last_logged_in")
	public Timestamp getLastLoggedIn() {
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Timestamp lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "enabled")
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// @OneToMany(mappedBy = "user")
	// public List<User> getListUserCreated() {
	// return listUserCreated;
	// }
	//
	// public void setListUserCreated(List<User> listUserCreated) {
	// this.listUserCreated = listUserCreated;
	// }
	//
	// @OneToMany(mappedBy = "user")
	// public List<WeeklySchedule> getListScheduleCreated() {
	// return listScheduleCreated;
	// }
	//
	// public void setListScheduleCreated(List<WeeklySchedule>
	// listScheduleCreated) {
	// this.listScheduleCreated = listScheduleCreated;
	// }

	/* **************** Access Permissions ************** */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_tenant_permissions", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "tenant_id") })
	public List<Tenant> getListTenant() {
		return listTenant;
	}

	public void setListTenant(List<Tenant> listTenant) {
		this.listTenant = listTenant;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_service_permissions", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "service_id") })
	public List<Service> getListService() {
		return listService;
	}

	public void setListService(List<Service> listService) {
		this.listService = listService;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_site_permissions", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "site_id") })
	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
}
