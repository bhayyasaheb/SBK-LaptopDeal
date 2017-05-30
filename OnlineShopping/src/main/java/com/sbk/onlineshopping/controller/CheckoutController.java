package com.sbk.onlineshopping.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sbk.shoppingbackend.dao.AddressDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Address;
import com.sbk.shoppingbackend.dto.User;

@Controller
public class CheckoutController {

	
	@Autowired 
	private AddressDAO addressDAO;
	
	@Autowired
	private User user;
	
	@Autowired 
	private UserDAO userDAO;
	
	@RequestMapping(value="/shippingAddress",method= RequestMethod.GET)
	public ModelAndView billingAddress()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("isUserClickedShippingAddress", true);
		mv.addObject("shippingAddress", new Address());
		
		
		return mv;
	}
	
	@RequestMapping(value="/shippingAddress", method=RequestMethod.POST)
	public String addBillingAddress(@Valid @ModelAttribute("shippingAddress") Address shippingAddress,BindingResult results,Model model,Principal principal)
	{
		user = userDAO.getByEmail(principal.getName());
		model.addAttribute("shippingAddress", new Address());
		
		if(results.hasErrors())
		{
			model.addAttribute("isUserClickedShippingAddress",true);
			model.addAttribute("shippingAddress", new Address());
			model.addAttribute("message","Failed to Add BillingAddress");
			
			return "page";
		}
		
		shippingAddress.setUser(user);
		shippingAddress.setShipping(true);
		addressDAO.addAddress(shippingAddress);
		return "thankYou1";
	}
	
	
}
