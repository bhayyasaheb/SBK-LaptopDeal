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
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.User;

@Controller
public class UserController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Cart cart;
	
	
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
		//mUser.setCart(cart);
		
		// check whether contact number already exist or not in database
		
		/*if(!mUser.getContact_number().isEmpty())
		{
			if(userDAO.getByContactNumber(mUser.getContact_number()) != null)
			{
				results.rejectValue("contact_number", null, "Contact Number Aready Present!");
			}
		}*/
		// check if there are any errors
		if(results.hasErrors())
		{
			model.addAttribute("userClickedRegister",true);
			model.addAttribute("title","Register");
			model.addAttribute("message","Validation failed for Registeraton");
			
			return "page";
		}
		
		logger.info(mUser.toString());
		
		mUser.setCart(cart);
		cart.setUser(mUser);
		
		
		// create new user
		userDAO.addUser(mUser);
		
		
		return "thankYou";
		//return "redirect:/register?operation=register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginUser()
	{
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("isUserClickedLogin",true);
		mv.addObject("title","Login");
		mv.addObject("user",getPrincipal());
		
		return mv;
		//return principal.toString();
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
	
	
	 private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	
	
		
}
