package com.bedrin.sna.interfaces;

public interface IMyList<T> {
	void add(T value);
	T get(int i);
	void remove(int i);
	void insert(int i, T value);
	int size();
}
