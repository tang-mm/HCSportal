package com.example.hcsweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hcsweb.model.users.User;

@Entity
@Table(name="customers")
public class Customer implements AbstractBean{ 
	private static final long serialVersionUID = -1633302818487879515L;

	/* **************** Attributes *****************/
	private int customerId;
	private String customerName;
	private String description;
	private List<Tenant> listTenant = new ArrayList<Tenant>();
	private List<User> listUser = new ArrayList<User>();
	
	/* **************** Constructors *****************/
	public Customer() { }
	
	public Customer(int id, String name, String desc) {
		this.customerId = id;
		this.customerName = name;
		this.description = desc; 
	}
 

	/**
	 * add a new Tenant into list and return the new list size
	 * @param t
	 * @return
	
	public int addNewTenant(Tenant t) {
		this.listTenants.add(t);
		return this.listTenants.size();
	} */
	
	/**
	 * remove a tenant from the list and return the new list size,
	 * return -1 if no tenant with the given ID exist
	 * @param tenantId
	 * @return
	 
	public int removeTenant(int tenantId) {
		for (Tenant t: this.listTenants) {
			if (t.getTenantId() == tenantId) {
				this.listTenants.remove(t);
				return listTenants.size();
			}
		}
		return -1;
	}*/

	/* **************** Getters and Setters *****************/
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	@Column(name = "customer_name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @OneToMany(mappedBy = "customer")
	public List<Tenant> getListTenant() {
		return listTenant;
	}

	public void setListTenant(List<Tenant> listTenant) {
		this.listTenant = listTenant;
	}

    @OneToMany(mappedBy = "customer")
	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	
	
}
