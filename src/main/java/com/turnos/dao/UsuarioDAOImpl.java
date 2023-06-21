package com.turnos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;

import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.DAOSentenceException;
import com.turnos.model.Usuario;


@Controller
public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void insertarUsuario(String dni, String password, String estado)
			throws DAOSentenceException, DAOConnectionException {
		Connection c = DBManager.connect();
		
		String sql = ("INSERT INTO USER (dni, password, estado) VALUES ('" + 
				dni+"','"+
				password+"','"+
				estado+"')");
		
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
	public boolean isUserValid(String dni, String password) throws DAOConnectionException {
		
		String sql = "SELECT * FROM USER WHERE dni = '"+dni+"' AND password = '"+password+"'";
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				String estado = rs.getString("estado");
				
				Usuario usuario = new Usuario(dni,password,estado);
				return true;
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
		return false;
	}
	
	



}
