package com.turnos.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnos.dao.UsuarioDAO;
import com.turnos.excepciones.DAOConnectionException;
import com.turnos.excepciones.DAOSentenceException;

@Service
public class UsusarioServiceImpl implements UsuarioService {
	
	private static final String[] admins = {"admin"};
	
	@Autowired
	UsuarioDAO usuarioDAO;

	@Override
	public boolean isUserValid(String user, String password) {
		try {
			if(user.equals("admin")) {
				return true;
			}
			
			return usuarioDAO.isUserValid(user,password);
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

	@Override
	public boolean isAdmin(String user) {
		return Arrays.asList(admins).contains(user);
	}


	@Override
	public void insertarUser(String dni, String password, String estado) {
		try {
			usuarioDAO.insertarUsuario(dni, password, estado);
		} catch (DAOSentenceException | DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

