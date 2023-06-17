package com.turnos.dao;

import java.util.List;

import com.turnos.model.DAOConnectionException;
import com.turnos.model.DAOSentenceException;
import com.turnos.model.Turno;
import com.turnos.model.Turno;


public interface TurnosDAO {
	
	void insertaTurno(Turno turno) throws DAOSentenceException, DAOConnectionException;
	
	Turno verTurno(int id) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponibles(String legajo, String fecha) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponibles(String fecha) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponibles(String legajo, String fecha, String hora) throws DAOConnectionException;
	
	List<Turno> listarTurnosByPaciente(String dni) throws DAOConnectionException;
	
	List<Turno> listarTurnosDisponiblesPorTerapista(String legajo) throws DAOConnectionException;

	Turno actualizarTurno(Integer id, String dni) throws DAOConnectionException;
}
