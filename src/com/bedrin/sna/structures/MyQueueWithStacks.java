package com.bedrin.sna.structures;

import com.bedrin.sna.utils.Pair;

public class MyQueueWithStacks<T extends Comparable<T>> {
	
	private MyPairStack<T> first;
	private MyPairStack<T> second;
	
	public MyQueueWithStacks() {
		first = new MyPairStack<T>();
		second = new MyPairStack<T>();
	}
	
	public void push(T t) {
		first.add(new Pair<T>(t, t));
	}
	
	public T getMin() {
		if(first.size() == 0) {
			return second.getMin();
		} 
		if(second.size() == 0) {
			return first.getMin();
		} 
		return  first.getMin().compareTo(second.getMin()) == -1 ? first.getMin() : second.getMin();
	}
	
	public T pop() {
		if(second.size() == 0) {
			while(first.size() != 0) {
				second.add(first.pop());
			}
		}
		return second.pop().getX();
	}

}
