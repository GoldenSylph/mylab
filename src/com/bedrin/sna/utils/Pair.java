package com.bedrin.sna.utils;

public class Pair<T extends Comparable<T>>{
	private T x;
	private T y;
	
	public Pair(T x, T y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(T x) {
		this.x = x;
	}
	
	public void setY(T y) {
		this.y = y;
	}
	
	public T getX() {
		return x;
	}
	
	public T getY() {
		return y;
	}
	
	public static <E extends Comparable<E>> int difference(E y1, E y2) {
		return y1.compareTo(y2);
	}

}
