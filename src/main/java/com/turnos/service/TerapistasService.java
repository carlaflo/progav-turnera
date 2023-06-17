package com.turnos.service;

import java.util.List;

import com.turnos.model.Terapista;

public interface TerapistasService {
	
	Terapista getTerapista(String legajo);
	
	List<Terapista> getAllTerapistas();
	
	void insertTerapista(Terapista t);

}
