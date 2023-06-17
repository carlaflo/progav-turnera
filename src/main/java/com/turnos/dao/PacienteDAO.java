package com.turnos.dao;

import java.util.List;

import com.turnos.model.DAOConnectionException;
import com.turnos.model.DAOSentenceException;
import com.turnos.model.Paciente;
import com.turnos.model.Patologia;

public interface PacienteDAO {
	
	void insertaPaciente(Paciente paciente) throws DAOSentenceException, DAOConnectionException;
	
	void insertaPaciente(Paciente paciente, Patologia pat) throws DAOSentenceException, DAOConnectionException;
	
	Paciente muestraPaciente(String dni) throws DAOConnectionException;
	
	List<Paciente> getAllPacientes() throws DAOConnectionException;

}
