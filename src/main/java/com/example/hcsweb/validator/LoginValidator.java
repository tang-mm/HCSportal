package com.example.hcsweb.validator;
 

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.hcsweb.model.usersEnum.User;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

//	public void validate(Object obj, Errors errors) {
//		User login = (User) obj;
//		if (login.getUsername() == null || login.getUsername().length() == 0) {
//			errors.rejectValue("username", "error.empty.field",
//					"Please Enter User Name");
//		} else if (!login.getUsername().equals("admin")) {
//			errors.rejectValue("username", "unknown.user", "Unknown User");
//		}
//		if (login.getPassword() == null || login.getPassword().length() == 0) {
//			errors.rejectValue("password", "error.empty.field",
//					"Please Enter Password");
//		} else if (!login.getPassword().equals("admin")) {
//			errors.rejectValue("password", "wrong.password", "Wrong Password");
//		}
//	}
 
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "j_username", "required.username");
	}

}