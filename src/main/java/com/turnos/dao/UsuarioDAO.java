package com.turnos.dao;

import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.DAOSentenceException;

public interface UsuarioDAO {
	
	void insertarUsuario(String dni, String password, String estado) throws DAOSentenceException, DAOConnectionException;
	
	boolean isUserValid(String dni, String password) throws DAOConnectionException;

}
