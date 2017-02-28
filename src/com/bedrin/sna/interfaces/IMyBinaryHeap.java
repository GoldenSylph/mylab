package com.bedrin.sna.interfaces;

public interface IMyBinaryHeap<T extends Comparable<T>> {
	
	void add(T a);
	
	T get(int i);
	T getLeft(int i);
	T getRight(int i);
	T getUp(int i);
	
	int search(T a);
	
	T pop(int i);
	T popLeft(int i);
	T popRight(int i);
	T popUp(int i);
	
	void mergeWith(IMyBinaryHeap<T> heap);
	int size();
	int growth();
	void pushDown(int i);
	void pushUp(int i);
	
	default int width() {
		return size();
	}
	
	default T getMax() {
		return get(0);
	}
}
