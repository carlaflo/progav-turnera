package com.turnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.turnos.login.service.UserValidationService;
import com.turnos.model.Paciente;
import com.turnos.model.Terapista;
import com.turnos.model.Turno;
import com.turnos.service.PacientesService;
import com.turnos.service.TerapistasService;
import com.turnos.service.TurnosService;


//VISTA
//TurnosRestImplementation

@Controller
public class TurnosController {
	
	@Autowired
	TurnosService service;
	
	@Autowired
	PacientesService pacService;
	
	@Autowired
	TerapistasService terapService;
	
	//Turnos disponibles de un terapista en una fecha
	@RequestMapping(value = "/terapistas/{legajo}/fecha/{fecha}", method= RequestMethod.GET)
	public String getTurno(ModelMap model, @PathVariable("legajo") String legajo, @PathVariable("fecha") String fecha) {
		
		
		List<Turno> t = service.getTurnos(legajo,fecha);
		model.addAttribute("turnos",t);
		return "turnos"; //returns login view
	}
	
	
	
	
	
	
	
	
	//Turnos disponibles de un terapista en una fecha
	@RequestMapping(value = "/terapistas/turnos", method= RequestMethod.POST)
	public String getTurnosDisponibles(ModelMap model, @ModelAttribute("turnofecha") String fecha, @ModelAttribute("terapistaId") String terap) {
		
		System.out.println("LA FECHA ES: "+fecha);
		System.out.println("LA FECHA ES: "+terap);
		
		//List<Turno> t = service.getTurnos(legajo,fecha);
		//model.addAttribute("turnos",t);
		return "turnos"; //returns login view
	}
	
	
	
	
	
	
	
	//Turnos disponibles para un paciente en una fecha
	@RequestMapping(value = "/pacientes/{dni}/fecha/{fecha}", method= RequestMethod.GET)
	public String getTurnoByTerapist(ModelMap model, @PathVariable("dni") String dni, @PathVariable("fecha") String fecha) {
		
		
		List<Turno> t = service.getTurnos(fecha);
		Paciente p = pacService.getPaciente(dni);
		model.addAttribute("turnos",t);
		model.addAttribute("paciente",p);
		return "turnos-paciente"; //returns login view
	}
	
	//Reserva turno
	@RequestMapping(value = "/turnos/{id}/pacientes/{dni}", method= RequestMethod.POST)
	public String getTurnoByTerapist(ModelMap model, @PathVariable("id") Integer id, @PathVariable("dni") String dni) {
		
		Turno t = service.reservarTurno(id,dni);
		
		model.addAttribute("turno",t);
		
		return "redirect:/pacientes/"+dni;
	}
	
	@RequestMapping(value = "/terapistas/{legajo}/turnos", method= RequestMethod.GET)
	public String getTurnos(ModelMap model, @PathVariable("legajo") String legajo) {
		model.addAttribute("turnos",service.getTurnosDisponiblesByTerapist(legajo));
		return "/turnos";
	}
	
	///turnos/${t.id}/pacientes
	@RequestMapping(value = "/turnos/{id}/pacientes", method= RequestMethod.GET)
	public String getPreReservarTurno(ModelMap model, @PathVariable("id") String turnoId) {
		model.addAttribute("turnos",pacService.getAllPacientes());
		return "/turnos";
	}
	
	
	//Turnos disponibles para un determinado paciente. El paciente no condiciona la busqueda
	//pero si no puede reservar, si tiene dos turnos ya asignados.
	@RequestMapping(value = "/pacientes/{dni}/turnos", method= RequestMethod.GET)
	public String getTurnosDisponiblesByFechaYTerapista(ModelMap model, @PathVariable("dni") String dni) {
		
		
		List<Terapista> t = terapService.getAllTerapistas();
		Paciente p = pacService.getPaciente(dni);
		model.addAttribute("terapistas",t);
		model.addAttribute("paciente",p);
		return "turnos-por-terapista"; //returns login view
	}
	
	
}
