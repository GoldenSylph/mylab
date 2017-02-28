package com.bedrin.sna.structures;

import com.bedrin.sna.interfaces.IMyBinaryHeap;
import com.bedrin.sna.utils.BinaryHeapElement;

public class MyBinaryHeap<T extends Comparable<T>> implements IMyBinaryHeap<T> {

	private MyListTL<T> list;
	
	public MyBinaryHeap() {
		this.list = new MyListTL<T>();
	}

	@Override
	public void add(T a) {
		this.list.add(a);
		pushUp(size() - 1);
	}
	
	@Override
	public T get(int i) {
		return this.list.peek(i);
	}
	
	@Override
	public T getLeft(int i) {
		return get(2 * i + 1);
	}

	@Override
	public T getRight(int i) {
		return get(2 * i + 2);
	}


	@Override
	public T getUp(int i) {
		return get((i - 1) / 2);
	}

	@Override
	public T pop(int i) {
		return null;
	}
	
	@Override
	public T popLeft(int i) {
		return null;
	}

	@Override
	public T popRight(int i) {
		return null;
	}
	
	@Override
	public T popUp(int i) {
		return null;
	}

	@Override
	public void mergeWith(IMyBinaryHeap<T> heap) {
		
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public int growth() {
		return 0;
	}

	@Override
	public void pushDown(int i) {
		BinaryHeapElement<T> t = new BinaryHeapElement<T>(i, get(i));
		BinaryHeapElement<T> tLeft = new BinaryHeapElement<T>(2 * i + 1, getLeft(i));
		BinaryHeapElement<T> tRight = new BinaryHeapElement<T>(2 * i  + 2, getRight(i));
		if(tLeft != null && t.getContent().compareTo(tLeft.getContent()) < 0) {
			BinaryHeapElement<T> tSwitch = tLeft;
			tLeft = t;
			t = tSwitch;
			tSwitch = null;
			this.list.set(tLeft.getNumber(), t.getContent());
			pushDown(tLeft.getNumber());
		}
		if(tRight != null) {
			BinaryHeapElement<T> tSwitch = tRight;
			tRight = t;
			t = tSwitch;
			tSwitch = null;
			this.list.set(tRight.getNumber(), t.getContent());
			pushDown(tRight.getNumber());
		}
	}

	@Override
	public void pushUp(int i) {
		T parent = getUp(i), current = get(i);
		if(current.compareTo(parent) > 0) {
			T temp = parent;
			this.list.set((i - 1) / 2, current);
			this.list.set(i, temp);
			pushUp((i - 1) / 2);
		}
	}

	@Override
	public int search(T a) {
		if(a.equals(get(0))) {
			return 0;
		} 
		if(getLeft(0) == null & getRight(0) == null) {
			return -1;
		}
		MyStack<BinaryHeapElement<T>> stack = new MyStack<BinaryHeapElement<T>>();
		MyListTL<BinaryHeapElement<T>> proceed = new MyListTL<BinaryHeapElement<T>>();
		proceed.add(new BinaryHeapElement<T>(0, get(0)));
		T left0 = getLeft(0), right0 = getRight(0);
		if (left0 != null) {
			stack.add(new BinaryHeapElement<T>(2, left0));
		}
		if (right0 != null) {
			stack.add(new BinaryHeapElement<T>(1, right0));
		}
		while(stack.size() != 0) {
			BinaryHeapElement<T> t = (BinaryHeapElement<T>) stack.top();  
			if(proceed.contains(t)) {
				stack.pop();
			} else {
				if(a.equals(t.getContent())) {
					return t.getNumber();
				}
				proceed.add(t);
				T left = getLeft(t.getNumber()), right = getRight(t.getNumber());
				if(left == null & right == null) {
					return -1;
				}
				BinaryHeapElement<T> t1 = null;
				if (left != null) {
					t1 = new BinaryHeapElement<T>(t.getNumber() * 2 + 1, left);
				}
				BinaryHeapElement<T> t2 = null;
				if (right != null) {
					t2 = new BinaryHeapElement<T>(t.getNumber() * 2 + 2, right);
				}
				if(!proceed.contains(t2)) {
					stack.add(t2);
				}
				if(!proceed.contains(t1)) {
					stack.add(t1);
				}
			}
		}
		return -1;
	}
	
}
