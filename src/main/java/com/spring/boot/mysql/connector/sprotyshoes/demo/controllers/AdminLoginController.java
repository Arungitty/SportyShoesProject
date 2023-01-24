package com.spring.boot.mysql.connector.sprotyshoes.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
	public String home() {
		System.out.println("this is home page");
		return "Alogin";
	 }
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public String WelcomePage(ModelMap model,@RequestParam String adminId,@RequestParam String password) {
		
		if(adminId.equals("jacky") && password.equals("root")) {
		  return "welcomeadmin"; 
		 }
		
		model.put("errorMsg","please provide correct userid and password");
	     return "Alogin";
	 }


	@RequestMapping(value="/adminlogout", method=RequestMethod.GET)
	public String Logout() {
		System.out.println("this is logout page");
		return "logout";
	 }

	@RequestMapping(value="/adminlogout", method=RequestMethod.POST)
	public String Logdone() {
		System.out.println("logout successful");
		return "logoutadmin";
	 }
	
}
