package com.turnos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.turnos.excepciones.TurnoReservaException;
import com.turnos.exportar.TurnosHistoricosExcelExport;
import com.turnos.model.Paciente;
import com.turnos.model.Terapista;
import com.turnos.model.Turno;
import com.turnos.service.PacientesService;
import com.turnos.service.TerapistasService;
import com.turnos.service.TurnosService;
import com.turnos.service.UsusarioServiceImpl;


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
		
		
		//List<Turno> t = service.getTurnos(legajo,fecha);
		List<Turno> t = new ArrayList();
		model.addAttribute("turnos",t);
		return "turnos"; //returns login view
	}
	
	//Turnos disponibles de un terapista en una fecha
	@RequestMapping(value = "/terapistas/turnos", method= RequestMethod.POST)
	public String getTurnosDisponibles(ModelMap model,
			@ModelAttribute("fechainicio") String inicio,
			@ModelAttribute("fechafin") String fin, 
			@ModelAttribute("teraplegajo") String terap, 
			@ModelAttribute("pacdni") String dni) {
		
		Terapista terapista = terapService.getTerapista(terap);
		
		if(inicio != null && fin !=null) {
			//el legajo del terapista es opcional. Si es null,
			//busco los turnos en el rango para todos los terapistas
			//si no es null, entonces busco en el rango solamente para ese
			//terapista
			List<Turno> t = service.getTurnos(terap,inicio,fin);
			model.addAttribute("turnos",t);
		}
		
		model.addAttribute("terap",terapista);
		model.addAttribute("pac",pacService.getPaciente(dni));
		
		return "turnos";
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
	public String getTurnoByTerapist(ModelMap model, @PathVariable("id") Integer id, @PathVariable("dni") String dni,
			RedirectAttributes redirectAttrs) {
		
		Turno t;
		try {
			t = service.reservarTurno(id,dni);
			model.addAttribute("turno",t);
		} catch (TurnoReservaException e) {
			redirectAttrs.addFlashAttribute("errorMessage","El paciente cuenta con 2 turnos reservados");
			e.printStackTrace();
		}
		
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
		Date date = Calendar.getInstance().getTime();
		String today = new SimpleDateFormat("MM-dd-YYYY").format(date);
		
		
		//Add one Day to the current date
        LocalDate currentdDate1 =  LocalDate.now();
        LocalDate currentDatePlus1 = currentdDate1.plusDays(7);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");
        String endDateSearch = currentDatePlus1.format(formatter);
		
		model.addAttribute("terapistas",t);
		model.addAttribute("paciente",p);
		model.addAttribute("todayBuscarTurnos",today);
		model.addAttribute("endDate",endDateSearch);
		
		return "buscar-turnos-disponibles";
	}
	
	//Cancelar turno
	@RequestMapping(value = "/turnos/{turnoId}", method= RequestMethod.POST)
	public String cancelarTurno(ModelMap model, 
			@PathVariable("turnoId") Integer id) {
		
		Turno t;
		String dni = null;
		
		try {
			Turno turnoActual = service.getTurno(id);
			dni = turnoActual.getDni();
			
			t = service.cancelarTurno(id);
			
		} catch (TurnoReservaException e) {
			e.printStackTrace();
			model.addAttribute("errorMessage","No se puede cancelar turno para el mismo dia.");
		} finally {
			model.addAttribute("turnos",service.getTurnosActivosByPaciente(dni));
			model.addAttribute("paciente",pacService.getPaciente(dni));
		}
		
		return "muestra-paciente";
	}
	
	
	@RequestMapping(value = "/paciente/{dni}/turnos-historico", method= RequestMethod.GET)
	public String getHistoricoTurnos(ModelMap model, 
			@PathVariable("dni") String dni) {
		
			
			/**
			 * ESTADO:
			 * 
			 * Siempre hablamos de estado distnto de null cuando el turno ya fue asignado a un paciente.
			 * Mientras el turno, no este reservado, el estado es null.
			 * 
			 * ASISTIDO: El paciente asistio al turno - lo actualiza la secretari cuando llega al turno
			 * PENDIENTE: El paciente reservo el turno pero el turno esta en el futuro - nada para hacer, se hizo la reserva por sistema
			 * VENCIDO: El paciente reservo y no asistio - para poder sacar un historico mas facil de estos casos.
			 */
			List<Turno> turnosEnElPasado = service.getTurnosPorEstadoYPaciente(dni, "ASISTIDO");
			
		
			model.addAttribute("turnos",turnosEnElPasado);
			model.addAttribute("paciente",pacService.getPaciente(dni));
		
		return "historico-turnos-paciente";
	}
	
	/***
	* Export data to excel file
	*/
	@RequestMapping(value = "/excelExport/{dni}", method= RequestMethod.GET)
	public ModelAndView exportToExcel(
			ModelMap model, 
			@PathVariable("dni") String dni) {
		
	    ModelAndView mav = new ModelAndView();
	    mav.setView(new TurnosHistoricosExcelExport());
	    
	    //read data from DB
	    List<Turno> turnos= service.getTurnosPorEstadoYPaciente(dni, "ASISTIDO");
	    //send to excelImpl class
	    mav.addObject("turnos", turnos);
	    return mav; 
	}
	
	
}
