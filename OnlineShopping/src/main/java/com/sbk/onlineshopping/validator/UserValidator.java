package com.sbk.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sbk.shoppingbackend.dto.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		
		// whether email address already in use
		if(user.getEmail() == null)
		{
			errors.rejectValue("email", null,"Please select an Email!");
			return;
		}
		
		if(!(user.getEmail()==null))
		{
			user.getEmail();
			errors.rejectValue("email", null,"Please Give another Email Adress this Email Address Already in Use!");
			return;
		}
		if(user.getContact_number()==null)
		{
			errors.rejectValue("contact_number", null,"Please Select  Contact Number");
			return;
		}
		if(!(user.getContact_number()==null))
		{
			errors.rejectValue("contact_number", null,"Please Give Another Contact Number this Number Already in Use!");
			return;
		}
	}

}
