package com.bedrin.sna.utils;

public class BinaryHeapElement<T> {
	
	private int number;
	private T content;
	
	public BinaryHeapElement(int number, T content) {
		this.number = number;
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setContent(T content) {
		this.content = content;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return obj instanceof BinaryHeapElement 
				&& ((BinaryHeapElement<T>) obj).getNumber() == this.number 
				&& ((BinaryHeapElement<T>) obj).getContent() == this.content;
	}
}
