package com.turnos.model;

import java.util.Date;

//Modelo (only Pojo)

public class Turno {
	
	private int id;
	
	private String fecha;
	private String hora;
	private String dni;
	private String legajo;
	private String estado;
	//private Visita visita;
	private Terapista t;
	private String fechaOperacion;
	
	
	
	public Turno(int id, String fecha, String hora, String dni, String legajo, String estado, String fechaOperacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.dni = dni;
		this.legajo = legajo;
		this.estado = estado;
		this.fechaOperacion = fechaOperacion;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public Terapista getTerapista() {
		return this.t;
	}
	public void setTerapista(Terapista t) {
		this.t = t;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	

}