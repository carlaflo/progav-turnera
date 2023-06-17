package com.turnos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.turnos.model.DAOConnectionException;
import com.turnos.model.DAOSentenceException;

public class DBManager {
	
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:~/test";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";
	
	
	public static Connection connect() throws DAOConnectionException {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
			c = DriverManager.getConnection(DB_BASE_URL, DB_USER, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch(ClassNotFoundException | SQLException e) {
			throw new DAOConnectionException(e);
		}
		
		return c; //retorna la coneccion
	}
	
	public static void execute (String sql) throws DAOConnectionException, DAOSentenceException {
		
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch(SQLException e) {
			try {
				c.rollback();
			} catch(SQLException el) {
				throw new DAOSentenceException(e);
			}
		} finally {
			try {
				c.close();
			}catch (SQLException el) {
				throw new DAOSentenceException(el);
			}
		}
	}

}
