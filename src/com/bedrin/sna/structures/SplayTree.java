package com.bedrin.sna.structures;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
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
	
	public void clear() {
		setRoot(null);
	}
	
	public StringBuilder bfsBuilder() {
		Queue<Node<K, V>> st = new ArrayDeque<>();
		StringBuilder b = new StringBuilder();
		st.add(getRoot());
		while(!st.isEmpty()) {
			Node<K, V> n = st.remove();
			b.append(n.value + " ");
			if(n.left != null) {
				st.add(n.left);
			}
			if(n.right != null) {
				st.add(n.right);
			}
		}
		return b;
	}
	
	public void bfs() {
		System.out.print(bfsBuilder().toString());
	}
	
	public void splay(K key) {
		if(getRoot().key == key) {
			return;
		}
		Node<K, V> current = peek(key);
		if((getRoot().left != null && getRoot().left == current)
				|| (getRoot().right != null && getRoot().right == current)) {
			zig(key);
			return;
		} 
		Node<K, V> previous = peekPrevious(current.key);
		Node<K, V> preprevious = peekPrevious(previous.key);
		if((preprevious.left == previous && previous.left == current) 
				|| (preprevious.right == previous && previous.right == current)) {
			zigZig(key);
			return;
		} 
		if((preprevious.right == previous && previous.left == current) 
				|| (preprevious.left == previous && previous.right == current)) {
			zigZag(key);
			return;
		}
	}
	
	public long height() {
		return tall(getRoot());
	}
	
	private long tall(Node<K, V> root) {
		if(root == null) return 0;
		return 1 + (Math.max(tall(root.left), tall(root.right)));
	}
	
	public long height(Node<K, V> node, K key) {
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
		Node<K, V> previous = peekPrevious(key);
		Node<K, V> preprevious = peekPrevious(previous.key);
		Node<K, V> temp = peek(key);
		Node<K, V> check = peekPrevious(preprevious.key);
		int cmp = key.compareTo(previous.key);
		if(cmp == 1) {
			preprevious.right = previous.left;
			previous.left = preprevious;
			previous.right = temp.right;
			temp.right = previous;
		} else if(cmp == -1) {
			preprevious.left = previous.right;
			previous.right = preprevious;
			previous.left = temp.left;
			temp.left = previous;
		}
		if(check != null) {
			if(check.left == preprevious) {
				check.left = temp;
			} else if(check.right == preprevious) {
				check.right = temp;
			}
			splay(temp.key);
		} else {
			setRoot(temp);
		}
	}
	
	private void zigZag(K key) {
		Node<K, V> previous = peekPrevious(key);
		Node<K, V> preprevious = peekPrevious(previous.key);
		Node<K, V> temp = peek(key);
		Node<K, V> check = peekPrevious(preprevious.key);
		int cmp = key.compareTo(previous.key);
		if(cmp == 1) {
			previous.right = temp.left;
			temp.left = previous;
			preprevious.left = temp.right;
			temp.right = preprevious;
		} else if(cmp == -1) {
			previous.left = temp.right;
			temp.right = previous;
			preprevious.right = temp.left;
			temp.left = preprevious;
		}
		if(check != null) {
			if(check.left == preprevious) {
				check.left = temp;
			} else if(check.right == preprevious) {
				check.right = temp;
			}
			splay(temp.key);
		} else {
			setRoot(temp);
		}
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
	
	@Override
	public String toString() {
		return bfsBuilder().toString();
	}
	
}
