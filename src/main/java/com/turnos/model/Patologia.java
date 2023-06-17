package com.turnos.model;

public class Patologia {
	
	private int id;
	private String nombre;
	
	public Patologia(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
