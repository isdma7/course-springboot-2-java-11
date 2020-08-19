package com.enterprise.course.services.exceptions;

import javassist.NotFoundException;

//vai ser uma subclasse do notfoundexception do java, excepçoes que o compilador nao obriga a tratar 
//Ora bem é uma classe abstrata, implementa da maneira dela metodos que ja estao feitos, como a classe gato implementar o metodo miau de forma diferente do metodo implementado na classe animal
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		//o super tras o metodo da classe pai no caso RuntimeException
		super("Resource not found. Id: " + id);
	}
}
