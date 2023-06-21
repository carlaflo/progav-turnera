package com.turnos.excepciones;

public class DAOConnectionException extends Exception {

	public DAOConnectionException() {
		
	}
	
	public DAOConnectionException(String message) {
		super(message);
	}
	
	public DAOConnectionException(Throwable cause) {
		super(cause);
	}
	
	public DAOConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
}
