package com.bedrin.sna.utils;

public class ElementTL<T> {
	
	private ElementTL<T> next;
	private T content;
	private ElementTL<T> previous;

	public ElementTL(T content) {
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
	
	public ElementTL<T> getNext() {
		return next;
	}

	public void setNext(ElementTL<T> next) {
		this.next = next;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public ElementTL<T> getPrevious() {
		return previous;
	}

	public void setPrevious(ElementTL<T> previous) {
		this.previous = previous;
	}
}
