package com.turnos.excepciones;

public class TurnoReservaException extends Exception {
	
	public TurnoReservaException() {
	
	}
	
	public TurnoReservaException(String message) {
		super(message);
	}
	
	public TurnoReservaException(Throwable cause) {
		super(cause);
	}
	
	public TurnoReservaException(String message, Throwable cause) {
		super(message, cause);
	}

}
