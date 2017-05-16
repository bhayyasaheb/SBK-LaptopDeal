package com.sbk.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		// check whether email already exist or not in database
		if(!mUser.getEmail().isEmpty()){
			if(userDAO.getByEmail(mUser.getEmail())!=null){
				results.rejectValue("email", null , "Email already present!");
			}
		}
		
		// check whether contact number already exist or not in database
		
		if(!mUser.getContact_number().isEmpty())
		{
			if(userDAO.getByContactNumber(mUser.getContact_number()) != null)
			{
				results.rejectValue("contact_number", null, "Contact Number Aready Present!");
			}
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
		
		return "thankYou";
		//return "redirect:/register?operation=register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginUser()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
			return ((UserDetails)principal).getUsername();
		/*ModelAndView mv = new ModelAndView("page");
		mv.addObject("isUserClickedLogin",true);
		mv.addObject("title","Login");
		
		return mv;*/
		return principal.toString();
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		//
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		//request.getSession().invalidate();
		return "redirect:/";
	}
	
	
	
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLoginSubmissionModel(Model model)
	{
		model.addAttribute("isUserClickedLogin",true);
		model.addAttribute("title","Login");
		
		return "page";
	}*/	
}
