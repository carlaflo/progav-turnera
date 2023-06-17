package com.turnos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.turnos.dao.TerapistaDAO;
import com.turnos.model.DAOConnectionException;
import com.turnos.model.DAOSentenceException;
import com.turnos.model.Terapista;


@Controller
public class TerapistasServiceImpl implements TerapistasService {
	
	@Autowired
	TerapistaDAO terapistaDAO;

	@Override
	public Terapista getTerapista(String legajo) {
		
		if(legajo != null) {
			Terapista t;
			try {
				t = terapistaDAO.muestraTerapista(legajo);
				return t;
			} catch (DAOConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return null;
	}
	
	@Override
	public List<Terapista> getAllTerapistas() {
		List<Terapista> l = new ArrayList<Terapista>();
		try {
			l.addAll(terapistaDAO.listarTerapistas());
			
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	@Override
	public void insertTerapista(Terapista t) {
		try {
			terapistaDAO.insertaTerapista(t);
		} catch (DAOSentenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
