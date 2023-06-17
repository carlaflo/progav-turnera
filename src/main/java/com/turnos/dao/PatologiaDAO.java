package com.turnos.dao;

import java.util.List;

import com.turnos.model.DAOConnectionException;
import com.turnos.model.Patologia;

public interface PatologiaDAO {
	
	List<Patologia> getAllPatologias() throws DAOConnectionException;
}
