package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IMyStack;

public class MyStack<T> implements IMyStack<T> {

	protected MyListTL<T> list;
	
	public MyStack() {
		list = new MyListTL<T>();
	}

	@Override
	public void add(T a) {
		list.add(a);
	}

	@Override
	public T pop() {
		T r = top();
		list.remove(size() - 1);
		return r;
	}

	@Override
	public T top() {
		return list.get(size() - 1);
	}

	@Override
	public String toString() {
		return list.toString();
	}
	
	@Override
	public int size() {
		return list.size();
	}
	
}
