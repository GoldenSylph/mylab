package com.bedrin.sna.utils;

public class Pair<T extends Comparable<T>> implements Comparable<T> {
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

	@Override
	public int compareTo(T o) {
		return this.x.compareTo(y);
	}
	
}
