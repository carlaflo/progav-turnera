package com.turnos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
		
	//Turnos disponibles de un terapista en una fecha
	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public String getTurno() {
		return "/home";
	}
	
}
