package com.bedrin.sna.exceptions;

public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9096383860314899469L;

	public ElementNotFoundException() {
		super("Нет такого элемента!");
	}
	
}
