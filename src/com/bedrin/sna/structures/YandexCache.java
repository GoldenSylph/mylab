package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IYandexCache;

public class YandexCache<K extends Comparable<K>, V> extends SplayTree<K, V> implements IYandexCache<K, V> {

	public final long CAPACITY;
	private long numberOfElements;
	
	public YandexCache(int size) {
		long t = 0;
		for(int i = size; i != 0; i--) {
			t += (long) Math.pow(2, i - 1);
		}
		CAPACITY = t;
		numberOfElements = 0;
	}
	
	@Override
	public void remove(K key) {
		numberOfElements--;
		super.remove(key);
	}
	
	@Override
	public void put(K key, V value) {
		if(numberOfElements >= CAPACITY) {
			forEachOnLevel(getRoot(), 1, height(), (node) -> {
				super.remove(node.key);
			});
		}
		super.add(key, value);
		numberOfElements++;
	}
	
}
