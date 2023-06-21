package com.turnos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.DAOSentenceException;
import com.turnos.model.Terapista;

@Controller
public class TerapistaDAOH2Impl implements TerapistaDAO {

	@Override
	public void insertaTerapista(Terapista medico) throws DAOSentenceException, DAOConnectionException {
		Connection c = DBManager.connect();
		
		String sql = ("INSERT INTO terapistas (nombre, apellido, legajo) VALUES ('" + medico.getNombre() +"' , "
				+ "'"+ medico.getApellido() +"' , '" + medico.getLegajo()+"')");
		
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
	public void borrarTerapista(String legajo) throws DAOSentenceException {
		String sql = "DELETE FROM medico WHERE legajo = '" + legajo +"'";
		try {
			DBManager.execute(sql);
		} catch (DAOConnectionException | DAOSentenceException e) {
			throw new DAOSentenceException(e);
		}
	}

	@Override
	public void actualizarTerapista(Terapista medico) throws DAOSentenceException {
		
		String sql = "UPDATE medico set nombre = '" + medico.getNombre() + "', apellido = '" + medico.getApellido() + 
						"' WHERE legajo = '" + medico.getLegajo() + "'";
		try {
			DBManager.execute(sql);
		} catch (DAOConnectionException | DAOSentenceException e) {
			throw new DAOSentenceException(e);
		}
	}

	@Override
	public Terapista muestraTerapista(String legajo) throws DAOConnectionException {
		String sql = "SELECT * FROM terapistas WHERE legajo = '" + legajo + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Terapista m = new Terapista (nombre, apellido, legajo);
				return m;
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
	public List<Terapista> listarTerapistas() throws DAOConnectionException {
		List<Terapista> resultado = new ArrayList<>();
		String sql = "SELECT * FROM terapistas";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String legajo = rs.getString("legajo");

				Terapista m = new Terapista(nombre, apellido, legajo);
				resultado.add(m);
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException el) {
				el.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException el) {
				el.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public void insertaTerapistas(List<Terapista> medicos) throws DAOConnectionException {
		Connection c = DBManager.connect();
		
		for(int i=0; i < medicos.size(); i++) {
			String nombre = medicos.get(i).getNombre();
			String apellido = medicos.get(i).getApellido();
			String legajo = medicos.get(i).getLegajo();
			
			String sql = "INSERT INTO medico (nombre, apellido, legajo, especialidad) VALUES ('" + nombre +"' , "
					+ "'"+ apellido +"' , '" + legajo;
			
			try {
				Statement s = c.createStatement();
				s.executeUpdate(sql);
				c.commit();
			} catch(SQLException e) {
				try {
					e.printStackTrace();
					c.rollback();
				} catch(SQLException el) {
					el.printStackTrace();
				}
			} 
		}
		try {
			c.close();
		}catch (SQLException el) {
			el.printStackTrace();
			}
		}
		
	}
	


