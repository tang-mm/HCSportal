package com.example.hcsweb.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.hcsweb.model.Tenant;

public class NewCustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Tenant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Tenant cust = (Tenant) obj;

		
	}
	
	
}
