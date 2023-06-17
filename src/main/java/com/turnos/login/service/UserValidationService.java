package com.turnos.login.service;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	
	public boolean isUserValid(String user, String password) {
		if (user.equals("carla") && password.equals("pelado")) 
			return true;
		return false;
		}
	}

