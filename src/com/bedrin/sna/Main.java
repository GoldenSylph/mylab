package com.bedrin.sna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bedrin.sna.structures.BilliardsHeap;
import com.bedrin.sna.structures.MyBinaryHeap;
import com.bedrin.sna.structures.MyListTL;
import com.bedrin.sna.structures.MyQueue;
import com.bedrin.sna.structures.MyQueueWithStacks;
import com.bedrin.sna.structures.MyStack;
import com.bedrin.sna.utils.Ball;

public class Main {
	
	public static void main(String[] args) {
		//System.out.println("В " + (Long.MAX_VALUE / 3_600_000 / 24 / 365 + 1970) + " году.");
		//billiardHeap();
		//heapTest()
		//listTest();
		//myQueueWithMinTest();
		encoding();
	}
	
	public static <T> Map<String, T> words(List<String> lst) {
		HashMap<String, T> r = new HashMap<String, T>();
		
		return r;
	}
	
	public static <V, K> Map<V, K> transform(Map<K, V> map) {
		return null;
	}
	
	public static void encoding() {
		File input = new File("input/en_input.txt");
		charPrint(input);
		File output = code(input, "xb");
		charPrint(output);
		output = code(output, "xb");
		charPrint(output);
	}
	
	private static void charPrint(File f) {
		try (FileReader fr = new FileReader(f)) {
			for(int i = 0; i < f.length(); i++) {
				System.out.print((char) fr.read());
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static File code(File f, String key) {
		if(key.length() > 2) {
			throw new RuntimeException("Wrong key!");
		}
		File r = new File("input/encoded.txt");
		MyQueue<Character> c = new MyQueue<>();
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			long l = f.length();
			for(int i = 0; i < l; i++, l -= 2) {
				boolean isOne = l != 1;
				c.add((char) fr.read());
				if (isOne) {
					c.add((char) fr.read());
				}
				c.add((char) (c.pop() ^ key.charAt(0)));
				if (isOne) {
					c.add((char) (c.pop() ^ key.charAt(1)));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(c);
		try (FileWriter fw = new FileWriter(r)) {
			while (c.size() != 0) {
				Character temp = c.pop();
				System.out.println(temp);
				fw.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
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
