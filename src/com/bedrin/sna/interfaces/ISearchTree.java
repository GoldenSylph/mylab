package com.bedrin.sna.interfaces;

public interface ISearchTree <T extends Comparable<T>>{
	void add(T t);
	boolean find(T t);
	boolean remove(T t);
}
