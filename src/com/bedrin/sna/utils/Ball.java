package com.bedrin.sna.utils;

public class Ball implements Comparable<Ball> {

	private int number;
	
	public Ball(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return number + "";
	}
	
	@Override
	public int compareTo(Ball o) {
		if(this.number > o.getNumber()) {
			return 1;
		} else if(this.number < o.getNumber()) {
			return -1;
		} else {
			return 0;
		}
	}

}
