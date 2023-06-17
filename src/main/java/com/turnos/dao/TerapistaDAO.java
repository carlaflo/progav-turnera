package com.turnos.dao;

import java.util.List;

import com.turnos.model.DAOConnectionException;
import com.turnos.model.DAOSentenceException;
import com.turnos.model.Terapista;

public interface TerapistaDAO {
	
	void insertaTerapista(Terapista Terapista) throws DAOSentenceException, DAOConnectionException;
	void insertaTerapistas(List<Terapista> Terapistas) throws DAOConnectionException;
	void borrarTerapista(String legajo) throws DAOSentenceException;
	void actualizarTerapista(Terapista Terapista) throws DAOSentenceException;
	Terapista muestraTerapista(String legajo) throws DAOConnectionException;
	List<Terapista> listarTerapistas() throws DAOConnectionException;

}
