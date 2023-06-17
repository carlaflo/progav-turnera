package com.turnos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.turnos.model.DAOConnectionException;
import com.turnos.model.DAOSentenceException;
import com.turnos.model.Paciente;
import com.turnos.model.Patologia;
import com.turnos.model.Terapista;

@Controller
public class PacienteDAOH2Impl implements PacienteDAO {

	@Override
	public void insertaPaciente(Paciente paciente) throws DAOSentenceException, DAOConnectionException {
		Connection c = DBManager.connect();
		
		String sql = ("INSERT INTO pacientes (dni, nombre, apellido ) VALUES ('" + paciente.getDni() +"' ,' "
				+ paciente.getNombre() +"', '"+ paciente.getApellido()+"')");
		
			try {
				Statement s = c.createStatement();
				s.executeUpdate(sql);
				c.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					c.close();
				}catch (SQLException el) {
					el.printStackTrace();
				}
			}
		
	}
	
	@Override
	public void insertaPaciente(Paciente paciente, Patologia pat) throws DAOSentenceException, DAOConnectionException {
		Connection c = DBManager.connect();
		
		String sql = ("INSERT INTO pacientes (dni, nombre, apellido ) VALUES ('" + paciente.getDni() +"' ,'"
				+ paciente.getNombre() +"', '"+ paciente.getApellido()+"')");
		
		String sqlPacPat = ("INSERT INTO PATOLOGIA_PACIENTE (IDPATOLOGIA, DNI) VALUES ('" + pat.getId() +"' ,'"
				+ paciente.getDni() +"')");
		
			try {
				Statement s = c.createStatement();
				s.executeUpdate(sql);
				
				Statement pacPat = c.createStatement();
				pacPat.executeUpdate(sqlPacPat);
				
				
				c.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					c.close();
				}catch (SQLException el) {
					el.printStackTrace();
				}
			}
		
	}


	@Override
	public Paciente muestraPaciente(String dni) throws DAOConnectionException {
		String sql = "SELECT * FROM pacientes WHERE dni = '" + dni + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				//String id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Paciente p = new Paciente (dni, nombre, apellido);
				return p;
			}
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException el) {
					el.printStackTrace();
				}
			} finally {
				try {
					c.close();
				}catch (SQLException el) {
					el.printStackTrace();
				}
			}
		return null;
	}
	
	
	@Override
	public List<Paciente> getAllPacientes() throws DAOConnectionException {
		List<Paciente> pacientes = new ArrayList();
		String sql = "SELECT * FROM pacientes";
		
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Paciente p = new Paciente (dni, nombre, apellido);
				pacientes.add(p);
			}
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException el) {
					el.printStackTrace();
				}
			} finally {
				try {
					c.close();
				}catch (SQLException el) {
					el.printStackTrace();
				}
			}
		return pacientes;
	}

}
	


