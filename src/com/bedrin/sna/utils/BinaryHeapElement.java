package com.bedrin.sna.utils;

public class BinaryHeapElement<T extends Comparable<T>> implements Comparable<BinaryHeapElement<T>>{
	
	private int number;
	private T content;
	
	public BinaryHeapElement(int number, T content) {
		if(content == null) {
			return;
		}
		this.number = number;
		this.content = content;
	}
	
	public BinaryHeapElement(BinaryHeapElement<T> element) {
		this(element.getNumber(), element.getContent());
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
	
	@Override
	public String toString() {
		return getContent().toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return obj instanceof BinaryHeapElement 
				&& ((BinaryHeapElement<T>) obj).getNumber() == this.number 
				&& ((BinaryHeapElement<T>) obj).getContent() == this.content;
	}

	@Override
	public int compareTo(BinaryHeapElement<T> o) {
		return getContent().compareTo(o.getContent());
	}

}
