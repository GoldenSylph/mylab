package com.bedrin.sna.structures;

import java.util.Comparator;
import java.util.function.UnaryOperator;

import com.bedrin.sna.interfaces.IMyBinaryHeap;

public class MyBinaryHeap<T extends Comparable<T>> implements IMyBinaryHeap<T> {

	protected MyListTL<T> list;
	protected Comparator<T> comparator;
	
	public MyBinaryHeap() {
		this.list = new MyListTL<T>();
	}
	
	public MyBinaryHeap(Comparator<T> comparator) {
		this.list = new MyListTL<T>();
		this.comparator = comparator;
	}

	@Override
	public void add(T a) {
		this.list.add(a);
		pushUp(size() - 1);
	}
	
	protected T get(int i) {
		return this.list.peek(i);
	}
	
	protected T getLeft(int i) {
		return get(2 * i + 1);
	}

	protected T getRight(int i) {
		return get(2 * i + 2);
	}


	protected T getUp(int i) {
		return get((i - 1) / 2);
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public void pushDown(int i) {
		T tLeft = null;
		T tRight = null;
		try {
			tLeft = getLeft(i);
			tRight = getRight(i);
		} catch (NullPointerException e) {}
		int max;
		if(tLeft == null) {
			max = 2 * i + 2;
		} else if(tRight == null) {
			max = 2 * i + 1;
		} else {
			max = comparator == null ? tLeft.compareTo(tRight) : comparator.compare(tLeft, tRight) >= 0 ? 2 * i + 1 : 2 * i + 2;
		}
		if(max <= size() && i >= 0 && i <= size() 
				&& (comparator == null ? get(i).compareTo(get(max)) : comparator.compare(get(i), get(max))) <= 0) {
			this.list.swap(i, max);
			pushDown(max);
		}
	}
	
	public MyListTL<T> sort() {
		MyListTL<T> r = new MyListTL<T>();
		final int heapSize = size();
		for(int i = 0; i < heapSize; i++) {
			int last = heapSize - 1 - i;
			r.add(get(0));
			this.list.swap(0, last);
			this.list.remove(last);
			pushDown(0);
		}
		return r;
	}

	@Override
	public void pushUp(int i) {
		T parent = getUp(i), current = get(i);
		int eq = comparator == null ? current.compareTo(parent) : comparator.compare(current, parent);
		if(eq > 0) {
			T temp = parent;
			this.list.set((i - 1) / 2, current);
			this.list.set(i, temp);
			pushUp((i - 1) / 2);
		}
	}

	@Override
	public void search(int from, UnaryOperator<T> operation) {
		MyStack<Integer> s = new MyStack<>();
		s.add(from);
		boolean[] used = new boolean[size()];
		while(s.size() != 0) {
			int v = s.top();
			used[v] = true;
			int l = 2 * v + 1, r = 2 * v + 2;
			if(l < size() && !used[l]) {
				s.add(l);
			} else if(r < size() && !used[r]) {
				s.add(r);
			} else {
				operation.apply(get(s.pop()));
			}
		}
	}

	public int growth() {
		return 0;
	}

	@Override
	public T getMax() {
		return get(0);
	}
	
	public void printWithStack(int from) {
		MyStack<Integer> s = new MyStack<>();
		s.add(from);
		boolean[] used = new boolean[size()];
		while(s.size() != 0) {
			int v = s.top();
			used[v] = true;
			int l = 2 * v + 1, r = 2 * v + 2;
			if(l < size() && !used[l]) {
				s.add(l);
			} else if(r < size() && !used[r]) {
				s.add(r);
			} else {
				System.out.print(s.pop() + " ");
			}
		}
	}
	
	public void printRecursive(int from) {
		if(2 * from + 1 < size()) {
			printRecursive(2 * from + 1);
		}
		if(2 * from + 2 < size()) {
			printRecursive(2 * from + 2);
		}
		System.out.print(get(from) + " ");
	}
	
	@Override
	public String toString() {
		return this.list.toString();
	}
	
}
