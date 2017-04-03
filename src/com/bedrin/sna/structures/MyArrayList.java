package com.bedrin.sna.structures;

import java.util.Arrays;

import com.bedrin.sna.exceptions.ElementNotFoundException;
import com.bedrin.sna.interfaces.IMyList;

public class MyArrayList implements IMyList<Object> {

	private int size;
	private Object[] container;
	
	public MyArrayList(int capacity) {
		this.container = new Object[capacity];
	}

	@Override
	public void add(Object value) {
		if(size == 0) {
			this.container = new Object[1];
		}
		if(size == this.container.length) {
			this.container = Arrays.copyOf(this.container, size * 2);
		}
		this.container[size++] = value;
	}
	
	public void add(Object value, int i) {
		if(size == 0 || i > size || i < 0) {
			throw new RuntimeException();
		}
		if(size == this.container.length) {
			this.container = Arrays.copyOf(this.container, size * 2);
		}
		Object[] t1 = Arrays.copyOfRange(this.container, 0, i);
		Object[] t2 = Arrays.copyOfRange(this.container, i, this.container.length);
		this.container = new Object[this.container.length + 1];
		for(int j = 0; j < t1.length; j++) {
			this.container[j] = t1[j];
		}
		this.container[i] = value;
		for(int j = t1.length - 1; j < this.container.length; j++) {
			this.container[j] = t2[j];
		}
		size++;
	}


	@Override
	public Object get(int i) {
		if(i > size || i < 0) {
			throw new ElementNotFoundException(i);
		}
		return this.container[i];
	}
	
	@Override
	public void remove(int i) {
		if(i > size || i < 0) {
			throw new ElementNotFoundException(i);
		}
		for(int j = i; j < this.container.length - 1; j++) {
			this.container[j] = this.container[j + 1];
		}
		size--;
	}

	@Override
	public void insert(int i, Object value) {
		
	}

	@Override
	public int size() {
		return size;
	}
	
	
	
}
