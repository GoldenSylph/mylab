package com.bedrin.sna.interfaces;

public interface ISplayTree<K extends Comparable<K>, V> extends ISearchTree<K, V> {
	ISplayTree<K, V> merge(ISplayTree<K, V> tree);
}
