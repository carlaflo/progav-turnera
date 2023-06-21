package com.turnos.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.turnos.dao.PacienteDAO;
import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.DAOSentenceException;
import com.turnos.model.Paciente;
import com.turnos.model.Patologia;



@Controller
public class PacientesServiceImpl implements PacientesService {
	
	@Autowired
	PacienteDAO pacienteDAO;

	@Override
	public Paciente getPaciente(String dni) {
		
		if(dni != null) {
			Paciente p;
			try {
				p = pacienteDAO.muestraPaciente(dni);
				return p;
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return null;
	}
	
	@Override
	public List<Paciente> getAllPacientes() {
		List<Paciente> pacs = new ArrayList();
		
		try {
			pacs.addAll(pacienteDAO.getAllPacientes());
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return pacs;
	}
	
	
	@Override
	public void insertPaciente(Paciente p) {
		try {
			pacienteDAO.insertaPaciente(p);
		} catch (DAOSentenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertPaciente(Paciente p, Patologia pat) {
		try {
			pacienteDAO.insertaPaciente(p,pat);
		} catch (DAOSentenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
