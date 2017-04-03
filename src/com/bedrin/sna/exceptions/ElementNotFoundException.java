package com.bedrin.sna.exceptions;

public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9096383860314899469L;

	public ElementNotFoundException(int position) {
		super("Нет такого элемента: " + position);
	}
	
	
}
