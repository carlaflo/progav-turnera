package com.turnos.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.turnos.dao.TurnosDAO;
import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.TurnoReservaException;
import com.turnos.model.Terapista;
import com.turnos.model.Turno;

//Controller
//All business logic

@Controller
public class TurnosServiceImpl implements TurnosService {
	
	@Autowired
	TurnosDAO turnosDAO;
	
	
	@Override
	public List<Turno> getAllTurnosByPaciente(String dni) {
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
	public List<Turno> getTurnosActivosByPaciente(String dni) {
		List<Turno> turnos = new ArrayList<Turno>();
		Date fecha = new Date();
		String str = new SimpleDateFormat("MM-dd-YYYY").format(fecha);
		
		if(dni != null) {
			try {
				turnos.addAll(turnosDAO.listarTurnosActivosByPaciente(dni, str));
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return turnos;
	}
	
	@Override
	public int getCantidadDeTurnosActivosByPaciente(String dni) {
		List<Turno> turnos = new ArrayList<Turno>();
		
		turnos = getTurnosActivosByPaciente(dni);	
		
		return turnos.size();
	}

	@Override
	public List<Turno> getTurnos(String legajo, String fechaInicio, String fechaFin) {
		List<Turno> turnos = new ArrayList<Turno>();
		
		if(fechaInicio != null && fechaFin != null) {
			try {
				turnos.addAll(turnosDAO.listarTurnosDisponibles(legajo,fechaInicio, fechaFin));
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
	
	
	/**
	 * Este metodo me retorna los turnos disponible para una fecha EXACTA.
	 */
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
	
	//Reserva turno para cliente
	@Override
	public Turno reservarTurno(Integer id, String dni) throws TurnoReservaException {
		Turno turno = null;
		
		//validar 2 turnos activos por paciente BR5
		
		int cantTurnos = getCantidadDeTurnosActivosByPaciente(dni);
		
		if (cantTurnos < 2) {
		
			if(id != null && dni != null) {
				try {
					turno = turnosDAO.actualizarTurno(id,dni);
				} catch (DAOConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		} else {
			throw new TurnoReservaException("El paciente cuenta con 2 turnos reservados");
		}
		
		return turno;
	}
	
	//cancela turno para cliente
		@Override
		public Turno cancelarTurno(Integer id) throws TurnoReservaException {
			Turno turno = null;
			
			Date date = Calendar.getInstance().getTime();
			String strFecha = new SimpleDateFormat("MM-dd-YYYY").format(date);
			
				if(id != null) {	
					turno = getTurno(id);	
						if (!(turno.getFecha().equals(strFecha))) {
							try {
								System.out.println("turno"+ turno.getFecha()+" // "+strFecha);
								turno = turnosDAO.cancelarTurno(id);
							} catch (DAOConnectionException e) {
								e.printStackTrace();
							}
						}else {
							throw new TurnoReservaException("No puede cancelar turno para el mismo dia");
							
						}
				} 
			
			return turno;
		}

		@Override
		public Turno getTurno(Integer id) {
			Turno t = null;
			
			try {
				t = turnosDAO.verTurno(id);
			} catch (NumberFormatException | DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return t;
		}

		@Override
		public List<Turno> getTurnosPorEstadoYPaciente(String dni, String estado) {
			List<Turno> turnos = new ArrayList();
			
			try {
				turnos = turnosDAO.listarHitoricoTurnosPorPaciente(dni, estado);
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return turnos;
		}

	
	


}
