package com.turnos.model;

import java.util.ArrayList;

public class Terapista {
	
	private String nombre;
	private String apellido;
	private String legajo;
	private ArrayList<HorarioDeAtencion> cronograma;
	
	public Terapista(String nombre, String apellido, String legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public ArrayList<HorarioDeAtencion> getCronograma() {
		return cronograma;
	}
	public void setCronograma(ArrayList<HorarioDeAtencion> cronograma) {
		this.cronograma = cronograma;
	}
	

}
