package validator;

import model.Customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NewCustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Customer cust = (Customer) obj;

		
	}
	
	
}
