package com.turnos.service;

import java.util.List;

import com.turnos.model.Turno;

public interface TurnosService {

	List<Turno> getTurnos(String legajo, String fecha);
	
	List<Turno> getTurnos(String fecha);
	
	List<Turno> getTurnosByPaciente(String dni);
	
	Turno reservarTurno(Integer turnoId, String dni);
	
	List<Turno> getTurnosDisponiblesByTerapist(String legajo);
	

}
