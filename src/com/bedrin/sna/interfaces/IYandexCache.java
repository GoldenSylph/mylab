package com.bedrin.sna.interfaces;

public interface IYandexCache<K, V> {
	V get(K key);
	void put(K key, V value);
}
