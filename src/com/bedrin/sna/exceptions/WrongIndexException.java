package com.bedrin.sna.exceptions;

public class WrongIndexException extends RuntimeException {

	private static final long serialVersionUID = 4825548090121824126L;

	public WrongIndexException() {
		super("Wrong format of index!");
	}
	
}
