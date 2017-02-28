package com.bedrin.sna;

import com.bedrin.sna.structures.MyBinaryHeap;
import com.bedrin.sna.structures.MyListOL;
import com.bedrin.sna.structures.MyListTL;
import com.bedrin.sna.structures.MyStack;

public class Main {
	
	public static void main(String[] args) {
		bracketsExercise();
		//heapTest();
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
						workspace.add(t);
						break;
						
					case ')':
					case ']':
					case '}':
						//конвертировать открывающуюся скобку t в закрывающуюся
						if(((char) workspace.top()) == t) {
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
	
	private static void heapTest() {
		MyBinaryHeap<Integer> h = new MyBinaryHeap<Integer>();
		h.add(1);
	}
	
	public static void listTest() {
		MyListOL<Object> list = new MyListOL<Object>();
		
		list.add("Whatever you want!"); // 0
		list.add(null); // 1
		list.add(1); // 2
		list.add(1.2f); // 3
		list.add(1.3d); // 4
		list.add(100000l); // 5
		list.add("Абракадабра"); // 5
		list.add("Ин вино - вэритас!"); // 5
		
		list.remove(0);
		list.remove(3);
		list.remove(5);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		MyListTL<Object> list2 = new MyListTL<Object>();
		list2.add("Whatever you want!"); 
		list2.add(null); 
		list2.add(1); 
		list2.add(1.2f); 
		list2.add(1.3d); 
		list2.add(100000l); 
		list2.remove(1);
		list2.insert(0, 2);
		list2.insert(3, 10);
		list2.insert(5, -100);
		System.out.println(list2.size());
		System.out.println(list2.get(0));
		System.out.println(list2.get(3));
		System.out.println(list2.get(5));
	}
	
}
