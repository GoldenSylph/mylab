package com.bedrin.algebras.exceptions;

public class EqualityException extends RuntimeException {

	private static final long serialVersionUID = -4196209048966954414L;

	public EqualityException() {
		super("Something is not equal to something!");
	}
	
}
