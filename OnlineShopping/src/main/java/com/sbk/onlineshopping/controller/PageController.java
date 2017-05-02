package com.sbk.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("greeting","welcome to spring web MVC");
		return mv;
	}
	
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting" , required=false) String greeting){
		if(greeting == null){
			greeting = "Hello there";
		}
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting){
		if(greeting == null){
			greeting = "Hello there";
		}
		ModelAndView mv = new ModelAndView("Page");
		mv.addObject("greeting", greeting);
		return mv;
	}
*/
}
