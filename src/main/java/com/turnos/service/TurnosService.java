package com.turnos.service;

import java.util.List;

import com.turnos.excepciones.TurnoReservaException;
import com.turnos.model.Turno;

public interface TurnosService {

	List<Turno> getTurnos(String legajo, String fechaInicio, String fechaFin);
	
	List<Turno> getTurnos(String fecha);
	
	List<Turno> getAllTurnosByPaciente(String dni);
	
	List<Turno> getTurnosActivosByPaciente(String dni);

	
	int getCantidadDeTurnosActivosByPaciente(String dni);
	

	
	Turno reservarTurno(Integer turnoId, String dni) throws TurnoReservaException;
	
	Turno cancelarTurno(Integer id) throws TurnoReservaException;
	
	List<Turno> getTurnosDisponiblesByTerapist(String legajo);
	
	Turno getTurno(Integer id);
	
	List<Turno> getTurnosPorEstadoYPaciente(String dni, String estado);
}
