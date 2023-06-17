package com.turnos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.turnos.dao.TurnosDAO;
import com.turnos.model.DAOConnectionException;
import com.turnos.model.Terapista;
import com.turnos.model.Turno;

//Controller
//All business logic

@Controller
public class TurnosServiceImpl implements TurnosService {
	
	@Autowired
	TurnosDAO turnosDAO;
	
	
	@Override
	public List<Turno> getTurnosByPaciente(String dni) {
		List<Turno> turnos = new ArrayList<Turno>();
		
		if(dni != null) {
			try {
				turnos.addAll(turnosDAO.listarTurnosByPaciente(dni));
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return turnos;
	}

	@Override
	public List<Turno> getTurnos(String legajo, String fecha) {
		List<Turno> turnos = new ArrayList<Turno>();
		
		if(legajo != null && fecha != null) {
			try {
				turnos.addAll(turnosDAO.listarTurnosDisponibles(legajo,fecha));
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return turnos;
	}
	
	@Override
	public List<Turno> getTurnosDisponiblesByTerapist(String legajo) {
		List<Turno> turnos = new ArrayList<Turno>();
		
		if(legajo != null) {
			try {
				turnos.addAll(turnosDAO.listarTurnosDisponiblesPorTerapista(legajo));
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return turnos;
	}
	
	@Override
	public List<Turno> getTurnos(String fecha) {
		List<Turno> turnos = new ArrayList<Turno>();
		
		if(fecha != null) {
			try {
				turnos.addAll(turnosDAO.listarTurnosDisponibles(fecha));
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return turnos;
	}
	
	@Override
	public Turno reservarTurno(Integer id, String dni) {
		Turno turno = null;
		
		if(id != null && dni != null) {
			try {
				turno = turnosDAO.actualizarTurno(id,dni);
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return turno;
	}

	
	


}
