package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IMyQueue;

public class MyQueue<T> implements IMyQueue<T> {

	private MyListTL<T> list;
	
	public MyQueue() {
		list = new MyListTL<T>();
	}
	
	@Override
	public void add(T o) {
		list.insert(0, o);
	}

	@Override
	public T first() {
		return list.get(size() - 1);
	}

	@Override
	public T pop() {
		T r = first();
		list.remove(size() - 1);
		return r;
	}

	@Override
	public int size() {
		return list.size();
	}

}
