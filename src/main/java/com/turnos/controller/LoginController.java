package com.turnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.turnos.login.service.UserValidationService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	UserValidationService service;
	
	@RequestMapping(value = "/login", method= RequestMethod.GET)
	public String showLoginPage() {
		return "login"; //returns login view
	}
	
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name,@RequestParam String password, ModelMap model) {
		if(!service.isUserValid(name,password)) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
		model.put("name",name);
		model.put("password",password);
		System.out.println(name);
		return "home"; 
	}
}
