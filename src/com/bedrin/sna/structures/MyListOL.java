package com.bedrin.sna.structures;

import com.bedrin.sna.exceptions.ElementNotFoundException;
import com.bedrin.sna.exceptions.WrongIndexException;
import com.bedrin.sna.interfaces.IMyList;
import com.bedrin.sna.utils.ElementOL;

public class MyListOL<T> implements IMyList<T> {

	private int size;
	private ElementOL<T> head;
	private ElementOL<T> tail;
	
	public MyListOL() {
		this.size = 0;
	}
	
	@Override
	public void add(T value) {
		ElementOL<T> temp = new ElementOL<T>(value);
		if(size() == 0) {
			head = tail = temp;
		} else {
			head.setNext(temp);
			head = temp;
		}
		size++;
	}

	@Override
	public T get(int i) {
		return getWithLeftOffset(i, 0).getContent();
	}

	@Override
	public void remove(int i) {
		if(i < 0 || i > size()) {
			throw new WrongIndexException();
		}
		if(i == 0) {
			ElementOL<T> temp = tail.getNext();
			tail.setNext(null);
			tail = temp;
		} else if(i == size() - 1) {
			ElementOL<T> temp = getWithLeftOffset(i, 1);
			temp.setNext(null);
			head = temp;
		} else {
			ElementOL<T> temp1 = getWithLeftOffset(i, 1);
			ElementOL<T> temp2 = getWithLeftOffset(i, 0);
			temp1.setNext(temp2.getNext());
			temp2.setNext(null);
		}
		size--;
	}
	
	public int size() {
		return size;
	}
	
	private ElementOL<T> getWithLeftOffset(int i, int offset) {
		ElementOL<T> temp = tail;
		ElementNotFoundException error = new ElementNotFoundException();
		int n = i - offset;
		if(n < 0 || n >= size()) {
			throw error;
		}
		for(int j = 1; j <= n; j++) {
			temp = temp.getNext();
		}
		return temp;
	}

	@Override
	public void insert(int i, T value) {
		
	}
	
}
