package com.sbk.onlineshopping.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.User;

public class UserValidator implements Validator{

	
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		
		// whether email address already in use
		if(user.getEmail().isEmpty()) {
			return;
		}else {
			System.out.println("-==================");
			System.out.println(userDAO);
			System.out.println("-==================");
			User t = userDAO.getByEmail(user.getEmail());
			
			if(t!=null)
			{
				errors.rejectValue("email", null,"Please Give another Email Adress this Email Address Already in Use!");
				return;
			}			
		}
		
		if(user.getContact_number().isEmpty()) {
			return;
		}
		else {
			if(userDAO.getByContactNumber(user.getContact_number())!=null)
			{
				errors.rejectValue("contact_number", null,"Please Give Another Contact Number this Number Already in Use!");
				return;
			}
		}
		
	}

}
