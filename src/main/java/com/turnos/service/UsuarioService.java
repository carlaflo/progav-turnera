package com.turnos.service;

public interface UsuarioService {
	
	public boolean isUserValid(String user, String password);
	
	public boolean isAdmin(String user);
	
	public void insertarUser(String dni, String password, String estado);

}
