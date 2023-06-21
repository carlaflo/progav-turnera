package com.turnos.excepciones;

public class DAOSentenceException extends Exception {

	public DAOSentenceException() {
		
	}
	
	public DAOSentenceException(String message) {
		super(message);
	}
	
	public DAOSentenceException(Throwable cause) {
		super(cause);
	}
	
	public DAOSentenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
