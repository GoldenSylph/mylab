package com.bedrin.sna.interfaces;

public interface ISearchTree<K extends Comparable<K>, V> {
	void add(K key, V value);
	V get(K key);
	void remove(K key);
	
}
