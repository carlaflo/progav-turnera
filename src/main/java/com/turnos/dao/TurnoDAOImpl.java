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
import com.turnos.model.Terapista;
import com.turnos.model.Turno;

//Modelo is where we have the connection to the DB
//Here is where we use Hibernate or JPA

@Controller
public class TurnoDAOImpl implements TurnosDAO {
	
	//entity
	
	public List<Turno> listarTurnosByPaciente(String dni) throws DAOConnectionException {
		List<Turno> resultado = new ArrayList<>();
		String sql = "SELECT * FROM turnos WHERE dni ='"+dni+"'";
		
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fechaQ = rs.getString("fecha");
				String hora = rs.getString("hora");
				//String dni = rs.getString("dni");
				String legajoQ = rs.getString("legajo");
				String estado = rs.getString("estado");

				//Turno(int id, String fecha, String hora, String dni, String legajo, String estado) {
				Turno t = new Turno(id, fechaQ, hora, dni, legajoQ, estado);
				resultado.add(t);
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
	public void insertaTurno(Turno turno) throws DAOSentenceException, DAOConnectionException {
		Connection c = DBManager.connect();
		
		String sql = ("INSERT INTO turnos (fecha, hora, dni, legajo, estado) VALUES ('" + turno.getFecha()+"', '"
				+turno.getHora()+"', '" +turno.getDni()+"', '"+turno.getLegajo()+"', 'N/A')");
		
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
	public Turno verTurno(int id) throws DAOConnectionException {
		String sql = "SELECT * FROM turnos WHERE id ="+id;
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				//int id = rs.getInt("id");
				String fecha = rs.getString("fecha");
				String hora = rs.getString("hora");
				String dni = rs.getString("dni");
				String legajo = rs.getString("legajo");
				String estado = rs.getString("estado");
				Turno t = new Turno (id, fecha, hora, dni, legajo, estado);
				return t;
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
	public List<Turno> listarTurnosDisponibles(String legajo, String fecha) throws DAOConnectionException {
		List<Turno> resultado = new ArrayList<>();
		String sql = "SELECT * FROM turnos WHERE legajo ='"+legajo+"' AND fecha = '"+fecha+"' AND DNI is null";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String fechaQ = rs.getString("fecha");
				String hora = rs.getString("hora");
				//String dni = rs.getString("dni");
				String legajoQ = rs.getString("legajo");
				String estado = rs.getString("estado");

				//Turno(String fecha, String hora, String dni, String legajo, String estado)
				Turno t = new Turno(id, fechaQ, hora, null, legajoQ, estado);
				resultado.add(t);
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
	public List<Turno> listarTurnosDisponibles(String legajo, String fecha, String hora) throws DAOConnectionException {
		List<Turno> resultado = new ArrayList<>();
		String sql = "SELECT * FROM turnos WHERE legajo ='"+legajo+
				"' AND fecha = '"+fecha+
				"' AND DNI is null AND hora = '"+hora+"'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String fechaQ = rs.getString("fecha");
				//String dni = rs.getString("dni");
				String legajoQ = rs.getString("legajo");
				String estado = rs.getString("estado");

				Turno t = new Turno(id, fechaQ, hora, null, legajoQ, estado);
				resultado.add(t);
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
	public List<Turno> listarTurnosDisponibles(String fecha) throws DAOConnectionException {
		List<Turno> resultado = new ArrayList<>();
		String sql = "SELECT * FROM turnos,terapistas WHERE turnos.fecha ='"+fecha+
				"' AND turnos.dni is null AND turnos.legajo = terapistas.legajo";
		
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String fechaQ = rs.getString("fecha");
				String horaq = rs.getString("hora");
				String legajoQ = rs.getString("turnos.legajo");
				String estado = rs.getString("estado");
				
				
				System.out.println("ID ES: "+id);
				
				//Terapista(String nombre, String apellido, String legajo)
				Terapista terap = new Terapista(rs.getString("nombre"),rs.getString("apellido"),
						rs.getString("turnos.legajo"));

				//Turno(int id, String fecha, String hora, String dni, String legajo, String estado)
				Turno t = new Turno(id, fechaQ, horaq, null, legajoQ, estado);
				t.setTerapista(terap);
				resultado.add(t);
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
	public Turno actualizarTurno(Integer id, String dni) throws DAOConnectionException {
		String sql = "UPDATE turnos SET turnos.dni='"+dni+"' WHERE turnos.id ='"+id+"'";
		Turno t = null;
		
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			
			t = this.verTurno(id);
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
		return t;
	}
	
	@Override
	public List<Turno> listarTurnosDisponiblesPorTerapista(String legajo) throws DAOConnectionException {
		List<Turno> resultado = new ArrayList<>();
		String sql = "SELECT * FROM turnos WHERE turnos.legajo ='"+legajo+"' AND turnos.dni is null";
		
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String fechaQ = rs.getString("fecha");
				String horaq = rs.getString("hora");
				String estado = rs.getString("estado");

				//Turno(int id, String fecha, String hora, String dni, String legajo, String estado)
				Turno t = new Turno(id, fechaQ, horaq, null, legajo, estado);
				resultado.add(t);
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

}
