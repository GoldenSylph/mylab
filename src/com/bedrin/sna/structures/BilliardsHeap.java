package com.bedrin.sna.structures;

public class BilliardsHeap<T extends Comparable<T>> extends MyBinaryHeap<T>{

	@Override
	public void pushUp(int i) {
		T parent = getUp(i), current = get(i);
		int eq = current.compareTo(parent);
		if(eq < 0) {
			T temp = parent;
			this.list.set((i - 1) / 2, current);
			this.list.set(i, temp);
			pushUp((i - 1) / 2);
		}
	}
		
	@Override
	public T getMax() {
		return null;
	}
	
	public T getMin() {
		return get(0);
	}
	
}
