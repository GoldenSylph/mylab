package com.bedrin.sna.utils;

public class ElementOL<T> {
	
	private ElementOL<T> next;
	private T content;

	public ElementOL(T content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		String result;
		try {
			result = this.content.toString();
		} catch (NullPointerException e) {
			result = "null";
		}
		return result;
	}
	
	public ElementOL<T> getNext() {
		return next;
	}

	public void setNext(ElementOL<T> next) {
		this.next = next;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
