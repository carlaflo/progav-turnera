package com.turnos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.turnos.excepciones.DAOConnectionException;
import com.turnos.model.Patologia;

@Controller
public class PatologiaDAOH2Impl implements PatologiaDAO {

	

	@Override
	public List<Patologia> getAllPatologias() throws DAOConnectionException {
		List<Patologia> resultado = new ArrayList<>();
		
		String sql = "SELECT * FROM patologias";
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				Patologia m = new Patologia(id, nombre);
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

	
		
}
	


