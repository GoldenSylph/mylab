package com.bedrin.sna.structures;

import java.util.function.Consumer;

public class SplayTree<K extends Comparable<K>, V> extends SearchTree<K, V> {

	public SplayTree() {}
	
	protected SplayTree(SplayTree.Node<K, V> root) {
		super(root);
	}

	@Override
	public void add(K key, V value) {
		super.add(key, value);
		splay(key);
	}
	
	@Override
	public V get(K key) {
		V v = super.get(key);
		splay(key);
		return v;
	}
	
	public void splay(K key) {
		long height = height(getRoot(), key);
		if(height == 2) {
			zig(key);
		} else if(height > 2) {
			Node<K, V> current = peek(key);
			Node<K, V> previous = peekPrevious(current.key);
			Node<K, V> preprevious = peekPrevious(previous.key);
			if(previous.key.compareTo(preprevious.left.key) == -1) {
				if(current.key.compareTo(previous.key) == -1) {
					zigZig(key);
				} else if(current.key.compareTo(previous.key) == 1) {
					zigZag(key);
				}
			} else if(previous.key.compareTo(preprevious.left.key) == 1) {
				if(current.key.compareTo(previous.key) == 1) {
					zigZig(key);
				} else if(current.key.compareTo(previous.key) == -1) {
					zigZag(key);
				}
			}
		}
	}
	
	public long height() {
		return tall(getRoot());
	}
	
	private long tall(Node<K, V> root) {
		if(root == null) return 0;
		return 1 + (Math.max(tall(root.left), tall(root.right)));
	}
	
	private long height(Node<K, V> node, K key) {
       Node<K, V> x = node;
       boolean isExist = x != null;
       long r = isExist ? 1 : 0;
       while(isExist) {
    	   if(key.compareTo(x.key) == -1) {
    		   x = x.left;
    		   r++;
    	   } else if(key.compareTo(x.key) == 1) {
    		   x = x.right;
    		   r++;
    	   } else {
    		   break;
    	   }
       }
       return r;
	}
	
	protected void forEachOnLevel(Node<K, V> root, long levelFrom, long levelTo, Consumer<Node<K, V>> function) {
		if(root == null) return;
		if(levelFrom == levelTo) {
			function.accept(root);
			return;
		}
		forEachOnLevel(root.left, levelFrom + 1, levelTo, function);
		forEachOnLevel(root.right, levelFrom + 1, levelTo, function);
	}
	
	private void zig(K key) {
		Node<K, V> temp = peek(key);
		Node<K, V> root = getRoot();
		if(key.compareTo(root.key) == -1) {
			root.left = temp.right;
			temp.right = root;
		} else if(key.compareTo(root.key) == 1) {
			root.right = temp.left;
			temp.left = root;
		}
		setRoot(temp);
	}
	
	@Override
	public void remove(K key) {
		splay(key);
		setRoot(merge(getRoot().left, getRoot().right).getRoot());
	}
	
	private void zigZig(K key) {
		zig(peekPrevious(key).key);
		zig(key);
		
	}
	
	private void zigZag(K key) {
		Node<K, V> previous = peekPrevious(key);
		Node<K, V> temp = peek(key);
		Node<K, V> root = getRoot();
		if(key.compareTo(previous.key) == 1) {
			previous.right = temp.left;
			temp.left = previous;
			root.left = temp;
		} else if(key.compareTo(previous.key) == -1) {
			previous.left = temp.right;
			temp.right = previous;
			root.right = temp;
		}
		setRoot(temp);
	}

	public static <K extends Comparable<K>, V> SplayTree<K, V> 
								merge(Node<K, V> root1, Node<K, V> root2) {
		SplayTree<K, V> tree1 = new SplayTree<K, V>(root1);
		SplayTree<K, V> tree2 = new SplayTree<K, V>(root2);
		Node<K, V> maxInFirstTree = tree1.getRoot();
		while(maxInFirstTree != null) {
			if(maxInFirstTree.right == null) {
				break;
			}
			maxInFirstTree = maxInFirstTree.right;
		}
		tree1.splay(maxInFirstTree.key);
		tree1.getRoot().right = tree2.getRoot();
		return tree1;
	}
	
}
