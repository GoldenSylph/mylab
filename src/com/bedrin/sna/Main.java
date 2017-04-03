package com.bedrin.sna;

import com.bedrin.sna.structures.BilliardsHeap;
import com.bedrin.sna.structures.MyBinaryHeap;
import com.bedrin.sna.structures.MyListTL;
import com.bedrin.sna.structures.MyQueueWithStacks;
import com.bedrin.sna.structures.MyStack;
import com.bedrin.sna.utils.Ball;

public class Main {
	
	public static void main(String[] args) {
		//billiardHeap();
		//heapTest();
		//listTest();
		myQueueWithMinTest();
	}
	
	public static void bracketsExercise() {
		String simpleRight = "(())((()())(()))";
		String simpleWrong = "((()";
		String complexRight = "([])[{{}()}]";
		String complexWrong = "({[}]())";
		
		System.out.println("SimpleRight - " + stackHelp(simpleRight));
		System.out.println("SimpleWrong - " + stackHelp(simpleWrong));
		System.out.println("ComplexRight - " + stackHelp(complexRight));
		System.out.println("ComplexWrong - " + stackHelp(complexWrong));
	}
	
	private static boolean stackHelp(String input) {
		MyStack<Character> workspace = new MyStack<Character>();
		for(int i = 0; i < input.length(); i++) {
			if(workspace.size() == 0) {
				workspace.add(input.charAt(i));
			} else {
				char t = input.charAt(i);
				switch (t) {
					case '(':
					case '[':
					case '{':
					case '<':
						workspace.add(t);
						break;
					case ')':
					case ']':
					case '}':
					case '>':
						if(bracketsCheck((char) workspace.top(), t)) {
							workspace.pop();
						} else {
							return false;
						}
						break;
				}
			}
		}
		if(workspace.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean bracketsCheck(char a, char b) {
		return (a == '(' && b == ')') || (a == '[' && b == ']') 
				|| (a == '{' && b == '}') || (a == '<' && b == '>'); 
	}
	
	public static void billiardHeap() {
		BilliardsHeap<Ball> b = new BilliardsHeap<>();
		b.add(new Ball(1));
		b.add(new Ball(2));
		b.add(new Ball(35));
		b.add(new Ball(16));
		b.add(new Ball(45));
		b.add(new Ball(88));
		b.add(new Ball(11));
		b.add(new Ball(90));
		b.add(new Ball(1000000));
		System.out.println(b.getMin());
	}
	
	public static void myQueueWithMinTest() {
		MyQueueWithStacks<Integer> q = new MyQueueWithStacks<>();
		q.push(5);
		q.push(1);
		q.push(9);
		System.out.println(q.getMin());
	}
	
	public static void heapTest() {
		MyBinaryHeap<Integer> heap = new MyBinaryHeap<Integer>();
		heap.add(4);
		heap.add(2);
		heap.add(6);
		heap.add(1);
		heap.add(3);
		heap.add(5);
		heap.add(7);
		//heap.printRecursive(0);
		//heap.printWithStack(0);
		System.out.println(heap);
		System.out.println(heap.sort());
	}
	
	public static void listTest() {
		MyListTL<Object> list3 = new MyListTL<Object>();
		list3.add(0); 
		list3.add(1); 
		list3.add(2); 
		list3.add(3); 
		list3.add(4);
		System.out.println(list3.get(0));
		System.out.println(list3.get(1));
		System.out.println(list3.get(2));
		System.out.println(list3.get(3));
		System.out.println(list3.get(4));
		list3.swap(4,  0);
		System.out.println();
		System.out.println(list3.get(0));
		System.out.println(list3.get(1));
		System.out.println(list3.get(2));
		System.out.println(list3.get(3));
		System.out.println(list3.get(4));
			
	}
	
}
