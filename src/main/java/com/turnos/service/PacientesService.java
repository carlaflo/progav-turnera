package com.turnos.service;

import java.util.List;

import com.turnos.model.Paciente;
import com.turnos.model.Patologia;

public interface PacientesService {
	
	Paciente getPaciente(String dni);
	
	void insertPaciente(Paciente p);
	
	void insertPaciente(Paciente p, Patologia pat);
	
	List<Paciente> getAllPacientes();

}
