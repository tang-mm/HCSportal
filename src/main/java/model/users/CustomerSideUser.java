package model.users;

import model.Customer;
 
public abstract class CustomerSideUser extends User {

	protected Customer customer; 
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
