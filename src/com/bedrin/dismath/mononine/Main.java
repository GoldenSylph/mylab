package com.bedrin.dismath.mononine;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static Line[] lines;
	
	public static BigInteger numOfMono;
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		//56 130 437 228 687 557 907 788
		numOfMono = new BigInteger("2");
		byte n = s.nextByte();
		lines = new Line[(short) Math.pow(2, n)];
		s.close();
		
		for(short i = 0; i < lines.length; i++) {
			lines[i] = new Line(i, n);
			System.out.println(lines[i]);
		}
		
		for(int i = 0; i < lines.length; i++) {
			if(lines[i].isMono()) {
				inc();
			}
		}

	}
	
	private static void inc() {
		numOfMono.add(BigInteger.ONE);
	}

}
