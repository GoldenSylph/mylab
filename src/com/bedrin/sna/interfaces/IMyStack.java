package com.bedrin.sna.interfaces;

public interface IMyStack<T> {
	void add(T a);
	T pop();
	T top();
	int size();
}
