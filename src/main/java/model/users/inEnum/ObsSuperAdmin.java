package model.users.inEnum;


public class ObsSuperAdmin extends User {


	public ObsSuperAdmin() {
		// TODO Auto-generated constructor stub
	}

	public ObsSuperAdmin(String username, String password) {
		super(username, password, UserTypeEnum.SUPER_ADMIN.getId());
		// TODO Auto-generated constructor stub
	}
}
