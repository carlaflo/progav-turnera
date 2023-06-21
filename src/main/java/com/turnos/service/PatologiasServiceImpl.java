package com.turnos.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.turnos.dao.PatologiaDAO;
import com.turnos.excepciones.DAOConnectionException;
import com.turnos.model.Patologia;



@Controller
public class PatologiasServiceImpl implements PatologiasService {
	
	@Autowired
	PatologiaDAO patologiaDAO;

	@Override
	public List<Patologia> getAllPatologias() {
		List<Patologia> p = new ArrayList();
		
		try {
			p.addAll(patologiaDAO.getAllPatologias());
			return p;
		} catch (DAOConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return p;
	}
	

}
