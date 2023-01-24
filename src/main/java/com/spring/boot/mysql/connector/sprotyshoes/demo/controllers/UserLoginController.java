package com.spring.boot.mysql.connector.sprotyshoes.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController {
	
	@RequestMapping(value="/arun", method=RequestMethod.GET)
	public String home() {
		System.out.println("this is home page");
		return "login";
	 }
	
	@RequestMapping(value="/arun", method=RequestMethod.POST)
	public String WelcomePage(ModelMap model,@RequestParam String userId,@RequestParam String password) {
		
		if(userId.equals("Sourav") && password.equals("root")) {
		  
			return "welcomeusers"; 
		 }
		
		model.put("errorMsg","please provide correct userid and password");
	    return "login";
	 }
	
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public String Logout() {
		System.out.println("this is logout page");
		return "logout";
	 }

	@RequestMapping(value="/log", method=RequestMethod.POST)
	public String Logdone() {
		System.out.println("User logout successful");
		return "logdone";
	 }
	
}






