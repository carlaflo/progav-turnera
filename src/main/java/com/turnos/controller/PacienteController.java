package com.turnos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.turnos.model.Paciente;
import com.turnos.model.Patologia;
import com.turnos.service.PacientesService;
import com.turnos.service.PatologiasService;
import com.turnos.service.TurnosService;
import com.turnos.service.UsuarioService;


//VISTA
//TurnosRestImplementation

@Controller
public class PacienteController {
	
	@Autowired
	PacientesService service;
	@Autowired
	PatologiasService patService;
	@Autowired
	TurnosService turnoService;
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/pacientes/{dni}", method= RequestMethod.GET)
	public String getPaciente(@PathVariable("dni") String dni, ModelMap model/*, RedirectAttributes redirectAttrs*/) {
		model.addAttribute("paciente",service.getPaciente(dni));
		System.out.println("ERROR: "+model.get("errorMessage"));
		model.addAttribute("turnos",turnoService.getTurnosActivosByPaciente(dni));
		
		return "muestra-paciente"; //returns login view
	}
	
	@RequestMapping(value = "/pacientes", method= RequestMethod.GET)
	public String getAllPacientes(ModelMap model) {
		model.addAttribute("pacientes",service.getAllPacientes());
		return "all-pacientes"; //returns login view
	}
	
	@RequestMapping(value = "/add-paciente", method= RequestMethod.GET)
	public String showPacienteForm(ModelMap model) {
		model.addAttribute("patologias",patService.getAllPatologias());
		return "pacientes-form";
	}
	
	@RequestMapping(value = "/add-paciente", method= RequestMethod.POST)
	public String addPaciente(ModelMap model,
			@RequestParam String dni,
			@RequestParam String nombre,
			@RequestParam String apellido, 
			@RequestParam String patologia,
			@RequestParam String password) {
		
		Paciente p = new Paciente(dni,nombre,apellido);
		Patologia pat = new Patologia(Integer.valueOf(patologia).intValue(),null);
		
		service.insertPaciente(p,pat);
		usuarioService.insertarUser(dni, password, "ACTIVO");
		model.clear();
		return "redirect:pacientes";//redireccionar a sacar turno. 
	}
	
	
}
