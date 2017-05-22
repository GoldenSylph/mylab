package com.bedrin.sna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bedrin.sna.structures.BilliardsHeap;
import com.bedrin.sna.structures.MyBinaryHeap;
import com.bedrin.sna.structures.MyListTL;
import com.bedrin.sna.structures.MyQueue;
import com.bedrin.sna.structures.MyStack;
import com.bedrin.sna.structures.SearchTree;
import com.bedrin.sna.structures.SplayTree;
import com.bedrin.sna.structures.YandexCache;
import com.bedrin.sna.utils.Ball;

public class Main {
	
	public static void main(String[] args) {
		//System.out.println("В " + (Long.MAX_VALUE / 3_600_000 / 24 / 365 + 1970) + " году.");
		//billiardHeap();
		//heapTest()
		//listTest();
		//myQueueWithMinTest();
		//encoding();
		//searchTree();
		splayTrees();
		//yandexCache();
	}
	
	public static void searchTree() {
		SearchTree<String, Integer> s = new SearchTree<>();
		s.add("oleg", 1);
		s.add("aizat", 2);
		s.add("damir", 3);
		System.out.println(s.get("oleg"));
		System.out.println(s.get("aizat"));
		System.out.println(s.get("damir"));
		s.remove("aizat");
		System.out.println(s.get("aizat"));
	}
	
	public static void yandexCache() {
		int t = 3;
		YandexCache<Integer, Integer> test = new YandexCache<>(t);
		for(int i = 0; i < test.CAPACITY; i++) {
			test.put(i, i + 1);
			System.out.println(i + ", " + (i + 1));
		}
		System.out.println();
		test.put(8, 9);
		System.out.println(test.get(7));
	}
	
	public static void splayTrees() {
		SplayTree<Integer, Integer> test = new SplayTree<>();
		test.add(5, 5);
		test.bfs();
		System.out.println();
		test.add(7, 7);
		test.bfs();
		System.out.println();
		test.get(5);
		test.bfs();
		System.out.println();
		test.add(3, 3);
		test.bfs();
		System.out.println();
		test.add(4, 4);
		test.bfs();
		System.out.println();
		test.get(7);
		test.bfs();
		System.out.println();
	}
	
	public static void encoding() {
		
//		System.out.println("Source:");
//		File input = new File("input/en_input.txt");
//		charPrint(input);
//		
//		System.out.println("Encoded:");
//		File output = code(input, "xc");
//		charPrint(output);
//		
//		System.out.println("Decoded:");
//		output = code(output, "xc");
//		charPrint(output);
		String input = "abacaba";
		String output = code(input, "xc");
		System.out.println(output);
		output = code(output, "xc");
		System.out.println(output);
	}
	
	private static String charPrint(File f) {
		StringBuilder sb = new StringBuilder();
		try (FileReader fr = new FileReader(f)) {
			for(int i = 0; i < f.length(); i++) {
				sb.append((char) fr.read());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String temp = sb.toString();
		System.out.println(temp);
		return temp;
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
			for(int i = 0; i < f.length() / 2; i++) {
				c.push((char) fr.read());
				c.push((char) fr.read());
				c.push((char) (c.pop() ^ key.charAt(0)));
				c.push((char) (c.pop() ^ key.charAt(1)));
			}
			if(f.length() % 2 == 0) {
				c.push((char) (fr.read() ^ key.charAt(0)));
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
		try (FileWriter fw = new FileWriter(r)) {
			while (c.size() != 0) {
				fw.append(c.pop());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	private static String code(String f, String key) {
//		if(key.length() > 2) {
//			throw new RuntimeException("Wrong key!");
//		}
//		MyQueue<Character> c = new MyQueue<>();
//		MyQueue<Character> buffer = new MyQueue<>();
//		for(int i = 0; i < f.length(); i++) {
//			//TODO
//		}
//		try {
//			for(int i = 0; i < f.length() / 2; i++) {
//				c.push(sb.);
//				c.push((char) fr.read());
//				c.push((char) (c.pop() ^ key.charAt(0)));
//				c.push((char) (c.pop() ^ key.charAt(1)));
//			}
//			if(f.length() % 2 == 0) {
//				c.push((char) (fr.read() ^ key.charAt(0)));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		StringBuilder sb = new StringBuilder();
//		while(c.size() != 0) {
//			sb.append(c.pop());
//		}
//		return sb.toString();
		return "";
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
		MyQueue<Integer> q = new MyQueue<>();
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
