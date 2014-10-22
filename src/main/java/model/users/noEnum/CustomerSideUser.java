package model.users.noEnum;

import model.Customer;

public class CustomerSideUser extends User {
	private Customer customer;

	public CustomerSideUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSideUser(String username, String password, int userTypeId) {
		super(username, password, userTypeId);
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
