package com.sbk.onlineshopping.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sbk.onlineshopping.validator.UserValidator;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.User;

@Controller
public class UserController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView registerUser(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickedRegister",true);
		mv.addObject("title","Register");
		
			User nUser= new User();
		// set the few of the fields 
		nUser.setEnabled(true);
		
		mv.addObject("register",nUser);
		
		if(operation != null)
		{
			if(operation.equals("register"))
			{
				mv.addObject("message","You are Registered Successfully!");
			}
		}
		
		return mv;
	}
	
	// handling user submission
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String handleUserSubmission(@Valid @ModelAttribute("register") User mUser,BindingResult results,Model model)
	{
		// handle email validation for new user
		if(!(mUser.getEmail()==null))
		{
			new UserValidator().validate(mUser,results);
		}
			
		
		
		
		
		// check if there are any errors
		if(results.hasErrors())
		{
			model.addAttribute("userClickedRegister",true);
			model.addAttribute("title","Register");
			model.addAttribute("message","Validation failed for Registeraton");
			
			return "page";
		}
		logger.info(mUser.toString());
		
		// create new user
		userDAO.add(mUser);
		
		
		return "redirect:/register?operation=register";
	}
}
