package com.bedrin.algebras;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	private static int n = 10_000_000;
	private static boolean[] primes = new boolean[n + 1];
	
	
	public static void main(String[] args) {
		ArrayList<Long> l = new ArrayList<Long>();
		fillSieve();
		for(int i = 2; i < primes.length; i++) {
			l.add((long) i);
		}
		System.out.println(l.toString());
	}
	
	public static void fillSieve() {
	    Arrays.fill(primes, true);
	    primes[0] = primes[1] = false;
	    for (int i = 2; i < primes.length; i++) {
	        if(primes[i]) {
	            for (int j = 2; i * j < primes.length; j++) {
	                primes[i * j] = false;
	            }
	        }
	    }
	}
	
}
