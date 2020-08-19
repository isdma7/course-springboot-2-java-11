package com.enterprise.course.services.exceptions;

public class DatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//construtor
	public DatabaseException(String msg) {
		super(msg); //vou passar para o construtor da classe acima para gerar a mensagem
	}

}
