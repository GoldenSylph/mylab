package com.bedrin.sna.structures;

import com.bedrin.sna.utils.Pair;

public class MyPairStack<T extends Comparable<T>> extends MyStack<Pair<T>> {
	
	@Override
	public void add(Pair<T> a) {
		T temp = null;
		if(size() != 0) {
			temp = top().getY();
		}
		if(temp != null && Pair.<T>difference(a.getY(), temp) == 1) {
			a.setY(temp);
		}
		super.add(a);
	}
	
	public T getMin() {
		return top().getY();
	}
	
}
