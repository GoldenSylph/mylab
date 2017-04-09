package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IMyQueue;

public class MyQueue<T> implements IMyQueue<T> {

	private MyListTL<T> list;
	
	public MyQueue() {
		list = new MyListTL<T>();
	}
	
	@Override
	public void add(T o) {
		if(size() == 0) {
			list.add(o);
		} else {
			list.insert(0, o);
		}
	}

	@Override
	public T first() {
		T r = pop();
		add(r);
		return r;
	}

	@Override
	public T pop() {
		int last = size() - 1;
		T r = list.get(last);
		list.remove(last);
		return r;
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
