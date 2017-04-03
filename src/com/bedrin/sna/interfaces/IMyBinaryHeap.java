package com.bedrin.sna.interfaces;

import java.util.function.UnaryOperator;

public interface IMyBinaryHeap<T extends Comparable<T>> {
	
	void add(T a);
	void search(int from, UnaryOperator<T> operation);
	int size();
	void pushDown(int i);
	void pushUp(int i);
	T getMax();
}
