package com.turnos.model;

public class Usuario {
	
	private String dni;
	private String password;
	private String estado;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String dni, String password, String estado) {
		super();
		this.dni = dni;
		this.password = password;
		this.estado = estado;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
