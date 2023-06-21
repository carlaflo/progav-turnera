package com.turnos.dao;

import java.util.Date;
import java.util.List;

import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.DAOSentenceException;
import com.turnos.model.Turno;
import com.turnos.model.Turno;


public interface TurnosDAO {
	
	void insertaTurno(Turno turno) throws DAOSentenceException, DAOConnectionException;
	
	Turno verTurno(int id) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponibles(String legajo, String fechaInicio, String fechaFin) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponibles(String fecha) throws DAOConnectionException;
	
	//List<Turno> listarTurnosDisponibles(String legajo, String fecha, String hora) throws DAOConnectionException;
	
	//Son todos los turno (pasado y presente)
	List<Turno> listarTurnosByPaciente(String dni) throws DAOConnectionException;
	
	List<Turno> listarTurnosActivosByPaciente(String dni, String fecha) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponiblesPorTerapista(String legajo) throws DAOConnectionException;

	Turno actualizarTurno(Integer id, String dni) throws DAOConnectionException;
	
	Turno cancelarTurno(Integer id) throws DAOConnectionException;
	
	List<Turno> listarTurnosByPaciente(String dni, String fechaInicio, String fechaFin) throws DAOConnectionException;
	
	List<Turno> listarHitoricoTurnosPorPaciente(String dni, String estado) throws DAOConnectionException;
}
