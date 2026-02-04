package com.educandoWeb.curso.services.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id ) {
		super("Resorurce not found . id " + id);
	}

}
