package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IMyDeque;

public class MyDeque<T> implements IMyDeque<T> {
	
	private MyListTL<T> list;

	public MyDeque() {
		list = new MyListTL<T>();
	}
	
	@Override
	public void addToStart(T o) {
		list.insert(0, o);
	}

	@Override
	public void addToEnd(T o) {
		list.add(o);
	}

	@Override
	public T seeFromStart() {
		return list.get(0);
	}

	@Override
	public T seeFromEnd() {
		return list.get(size() - 1);
	}

	@Override
	public T popFromStart() {
		return popHelp(0);
	}

	@Override
	public T popFromEnd() {
		return popHelp(size() - 1);
	}

	private T popHelp(int position) {
		T r = list.get(position);
		list.remove(position);
		return r;
	}
	
	@Override
	public int size() {
		return list.size();
	}
}
