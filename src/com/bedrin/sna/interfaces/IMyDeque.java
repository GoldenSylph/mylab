package com.bedrin.sna.interfaces;

public interface IMyDeque<T> {
	void addToStart(T o);
	void addToEnd(T o);
	T seeFromStart();
	T seeFromEnd();
	T popFromStart();
	T popFromEnd();
	int size();
}
