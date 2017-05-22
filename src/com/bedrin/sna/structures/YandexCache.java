package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IYandexCache;

public class YandexCache<K extends Comparable<K>, V> extends SplayTree<K, V> implements IYandexCache<K, V> {

	public final long CAPACITY;
	private long numberOfElements;
	
	public YandexCache(int size) {
		CAPACITY = (long) Math.pow(2, size + 1) - 1;
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
				remove(node.key);
			});
		}
		super.add(key, value);
		numberOfElements++;
	}
	
}
