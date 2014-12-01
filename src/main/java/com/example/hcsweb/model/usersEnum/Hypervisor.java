package com.example.hcsweb.model.usersEnum;

import java.util.List;

import com.example.hcsweb.model.Tenant;

public class Hypervisor extends CustomerSideUser{

	private List<Tenant> tenants;
	
	public Hypervisor() {}
	
	public Hypervisor(String username, String password) {
		super(username, password, UserTypeEnum.HYPERVISOR.getId()); 
		
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	} 
	
	public void addTenant(Tenant t) {
		this.tenants.add(t);
	}
	
	public int removeTenant(int tenantId) {
		for (Tenant t : this.tenants) {
			if (t.getTenantId() == tenantId) {
				this.tenants.remove(t);
				return tenantId;
			}
		} 
		return -1;
	}
}
