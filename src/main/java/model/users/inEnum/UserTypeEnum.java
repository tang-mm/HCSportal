package model.users.inEnum;

/**
 * (UserType -- UserTypeId) association;
 * Should be synchronized with userTypes defined in Database
 */
public enum UserTypeEnum {
	
	SUPER_ADMIN(1, "Super Administrator"), 
	EXPERT_L3(2, "Expert L3"), 
	EXPERT_L2(3, "Expert L2"),
	EXPERT_L1(4, "Expert L1"), 
	CUSTOMER_ADMIN(5, "Administrator"), 
	SUPERVISOR(6, "Supervisor"), 
	AGENT(7, "Agent");

	private final int id;
	private final String type;

	private UserTypeEnum(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	/**
	 * find the corresponding user type as an Enum instance by id
	 * @param id
	 * @return
	 */
	public static UserTypeEnum getEnumById(int id) throws IllegalArgumentException{
		for (UserTypeEnum type : UserTypeEnum.values()) {
			if (type.getId() == id)
				return type;
		}
		throw new IllegalArgumentException("UserType with [Id = " + id + "] is not defined!");
	}
	
	/**
	 * find the full name of the corresponding user type 
	 * 
	 * @param id
	 * @return 
	 */
	public static String getUserTypeById(int id){
			return getEnumById(id).getType(); 
	}

	/**
	 * find the name of the enum constant exactly as it is declared
	 * 
	 * @param id
	 * @return
	 */
	public static String getEnumNameById(int id){
		return getEnumById(id).name(); 
	}
}
