package com.example.hcsweb.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.hcsweb.model.usersEnum.User;

public class NewUserValidator implements Validator {

	private static final int PASSWORD_LENGTH_MIN = 6;
	private static final int PASSWORD_LENGTH_MAX = 18;

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"field.required", "Required field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"field.required", "Required field");
		if (user.getUserTypeId() == -1)
			errors.rejectValue("userTypeId", "field.required", "Required field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmedPassword",
				"field.required", "Required field");

		
		// password length
		if (user.getPassword().length() < PASSWORD_LENGTH_MIN
				|| user.getPassword().length() > PASSWORD_LENGTH_MAX)
			errors.rejectValue("password", "password_length",
					"Password length should be between " + PASSWORD_LENGTH_MIN
							+ "and " + PASSWORD_LENGTH_MAX + " characters!");

		// check confirmed password
		if (user.getPassword() != null) {
			if (!user.getPassword().equals(user.getConfirmedPassword()))
				errors.rejectValue("confirmedPassword", "");
		}
	}

}
