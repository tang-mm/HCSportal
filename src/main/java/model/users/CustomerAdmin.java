package model.users;

public class CustomerAdmin extends CustomerSideUser {

	public CustomerAdmin() {
		// TODO Auto-generated constructor stub
	}

	public CustomerAdmin(String username, String password) { 
		super(username, password, UserTypeEnum.CUSTOMER_ADMIN.getId());
	}

}
