package com.bedrin.sna.interfaces;

public interface IMyQueue<T> {
	void add(T o);
	T first();
	T pop();
	int size();
}
