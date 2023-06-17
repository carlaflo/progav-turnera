package com.turnos.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.turnos.model.Terapista;

import com.turnos.service.TerapistasService;



//VISTA
//TurnosRestImplementation

@Controller
public class TerapistaController {
	
	@Autowired
	TerapistasService service;
	
	@RequestMapping(value = "/terapistas/{legajo}", method= RequestMethod.GET)
	public String getTurno(@PathVariable("legajo") String legajo, ModelMap model) {
		model.addAttribute("terapista",service.getTerapista(legajo));
		return "muestra-terapista"; //returns login view
	}
	
	@RequestMapping(value = "/terapistas", method= RequestMethod.GET)
	public String getAllTerapistas(ModelMap model) {
		model.addAttribute("terapistas",service.getAllTerapistas());
		return "all-terapistas"; //returns login view
	}
	
	@RequestMapping(value = "/add-terapista", method= RequestMethod.GET)
	public String showTerapistaForm(ModelMap model) {
		return "terapistas-form";
	}
	
	@RequestMapping(value = "/add-terapista", method= RequestMethod.POST)
	public String addTerapista(ModelMap model,@RequestParam String nombre,
			@RequestParam String apellido,@RequestParam String legajo) {
		System.out.println(nombre+"-"+apellido+"-"+legajo);
		Terapista t = new Terapista(nombre,apellido,legajo);
		service.insertTerapista(t);
		model.clear();
		return "redirect:terapistas";
	}
	
	
}
