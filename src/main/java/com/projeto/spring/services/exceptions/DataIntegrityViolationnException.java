package com.projeto.spring.services.exceptions;

public class DataIntegrityViolationnException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DataIntegrityViolationnException(String msg) {
		super(msg);
	}
	
	public DataIntegrityViolationnException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
