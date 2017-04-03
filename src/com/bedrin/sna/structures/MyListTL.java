package com.bedrin.sna.structures;

import com.bedrin.sna.exceptions.ElementNotFoundException;
import com.bedrin.sna.exceptions.WrongIndexException;
import com.bedrin.sna.interfaces.IMyList;
import com.bedrin.sna.utils.ElementTL;

public class MyListTL<T> implements IMyList<T> {

	private int size;
	private ElementTL<T> head;
	private ElementTL<T> tail;
	
	public MyListTL() {
		this.size = 0;
	}
	
	public MyListTL(MyListTL<T> list) {
		this.size = list.size();
		setHead(list.getHead());
		setTail(list.getTail());
	}
	
	protected void setHead(ElementTL<T> head) {
		this.head = head;
	}
	
	protected void setTail(ElementTL<T> tail) {
		this.tail = tail;
	}
	
	public ElementTL<T> getHead() {
		return head;
	}
	
	public ElementTL<T> getTail() {
		return tail;
	}
	
	@Override
	public void add(T value) {
		ElementTL<T> temp = new ElementTL<T>(value);
		if(size() == 0) {
			tail = head = temp;
		} else {
			temp.setPrevious(head);
			head.setNext(temp);
			head = temp;
		}
		this.size++;
	}

	@Override
	public T get(int i) {
		return getThroughOptimizedWay(i, true).getContent();
	}
	
	public T peek(int i) {
		return getThroughOptimizedWay(i, false).getContent();
	}
	
	public void set(int i, T obj) {
		getThroughOptimizedWay(i, true).setContent(obj);
	}
	
	public void swap(int i, int j) {
		if(i == j) {
			return;
		}
		ElementTL<T> t1 = getThroughOptimizedWay(i, true);
		ElementTL<T> t2 = getThroughOptimizedWay(j, true);
		ElementTL<T> tTemp = new ElementTL<T>(t1);
		set(i, t2.getContent());
		set(j, tTemp.getContent());
	}
	
	@Override
	public void remove(int i) {
		if(i < 0 || i > size) {
			throw new WrongIndexException();
		}
		if(i == 0) {
			tail = tail.getNext();
			if(tail != null) {
				tail.setPrevious(null);
			}
		} else if(i == size() - 1) {
			head = head.getPrevious();
			head.setNext(null);
		} else {
			ElementTL<T> temp0 = getThroughOptimizedWay(i, true);
			ElementTL<T> temp1 = temp0.getNext();
			ElementTL<T> temp2 = temp0.getPrevious();
			temp0.setNext(null);
			temp0.setPrevious(null);
			temp2.setNext(temp1);
			temp1.setPrevious(temp2);
		}
		this.size--;
	}
	
	private ElementTL<T> getFromTailToHeadWithLeftOffset(int i, int offset, boolean nl) {
		ElementTL<T> temp = tail;
		int n = i - offset;
		if(n < 0 || n >= size()) {
			if(nl) {
				throw new ElementNotFoundException(n);
			} else {
				return null;
			}
		}
		for(int j = 1; j <= n; j++) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	private ElementTL<T> getFromHeadToTailWithLeftOffset(int i, int offset, boolean nl) {
		ElementTL<T> temp = head;
		int n = this.size - i - 1 + offset;
		if(n < 0 || n >= size()) {
			if(nl) {
				throw new ElementNotFoundException(n);
			} else {
				return null;
			}
		}
		for(int j = 0; j < n; j++) {
			temp = temp.getPrevious();
		}
		return temp;
	}
	
	private ElementTL<T> getThroughOptimizedWay(int i, boolean nl) {
		if(i < this.size / 2) {
			return getFromTailToHeadWithLeftOffset(i, 0, nl);
		} else {
			return getFromHeadToTailWithLeftOffset(i, 0, nl);
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	public boolean contains(T a) {
		for(int i = 0; i < size(); i++) {
			if(a.equals(getThroughOptimizedWay(i, true))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void insert(int i, T value) {
		ElementTL<T> temp = new ElementTL<T>(value);
		if(i == size() - 1) {
			add(value);
		} else if(i == 0) {
			temp.setNext(tail);
			tail.setPrevious(temp);
			tail = temp;
		} else {
			ElementTL<T> cur = getThroughOptimizedWay(i, true);
			ElementTL<T> temp1 = cur.getPrevious();
			cur.setPrevious(temp);
			temp.setNext(cur);
			temp1.setNext(temp);
			temp.setPrevious(temp1);
		}
		size++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size(); i++) {
			sb.append(peek(i)).append(" ");
		}
		return sb.toString();
	}
	
}
