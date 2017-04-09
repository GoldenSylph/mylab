package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.ISearchTree;

public class SearchTree<K extends Comparable<K>, V> implements ISearchTree<K, V>{

	private Node<K, V> root;
	
	@Override
	public void add(K key, V value) {
		Node<K, V> x = root, y = null;
        while (x != null) {
        	int cmp = key.compareTo(x.key);
        	if (cmp == 0) {
        		x.value = value;
        		return;
        	} else {
        		y = x;
        		if (cmp < 0) {
        			x = x.left;
        		} else {
        			x = x.right;
        		}
        	}
        }
        Node<K, V> newNode = new Node<K, V>(key, value);
        if (y == null) {
        	root = newNode;
        } else {
        	if(key.compareTo(y.key) < 0) {
        		y.left = newNode;
        	} else {
        		y.right = newNode;
        	}
        }
	}

	@Override
	public V get(K key) {
		Node<K, V> x = root;
        while (x != null) {
        	int cmp = key.compareTo(x.key);
        	if (cmp == 0) {
        		return x.value;
        	}
        	if (cmp < 0) {
        		x = x.left;
        	} else {
        		x = x.right;
        	}
        }
        return null;
	}

	@Override
	public void remove(K key) {
		Node<K, V> x = root, y = null;
        while (x != null) {
        	int cmp = key.compareTo(x.key);
        	if (cmp == 0) {
        		break;
        	} else {
        		y = x;
        		if(cmp < 0) {
        			x = x.left;
        		} else {
        			x = x.right;
        		}
        	}
        }
        if(x == null) {
        	return;
        }
        if(x.right == null) {
        	if(y == null) {
        		root = x.left;
        	} else {
        		if(x == y.left) {
        			y.left = x.left;
        		} else {
        			y.right = x.left;
        		}
        	}
        } else {
        	Node<K, V> leftMost = x.right;
        	y = null;
        	while(leftMost.left != null) {
        		y = leftMost;
        		leftMost = leftMost.left;
        	}
        	if(y != null) {
        		y.left = leftMost.right;
        	} else {
        		x.right = leftMost.right;
        	}
        	x.key = leftMost.key;
        	x.value = leftMost.value;
        }
	}
	
	private static class Node<K, V> {
		public K key;
        public V value;
        public Node<K, V> left, right;
       
        public Node(K key, V value) {
        	this.key = key;
        	this.value = value;
        }
	}
}