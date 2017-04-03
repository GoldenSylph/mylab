package com.bedrin.mathanalysis.lessquads;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MethodOfLeastQuads {

	public static void main(String[] args) {
		
		HashMap<Long, Long> data = new HashMap<Long, Long>();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Введите количество данных.");
		long n = s.nextLong() - 1;
		System.out.println("Введите точность.");
		byte p = s.nextByte();
		System.out.println("Введите данные.");
		for(long i = 0; i < n; i++) {
			data.put(s.nextLong(), s.nextLong());
		}
		s.close();
		
		BigDecimal sumOfXY = new BigDecimal("0");
		for(Entry<Long, Long> i : data.entrySet()) {
			sumOfXY = sumOfXY.add(new BigDecimal(i.getKey() + "").multiply(new BigDecimal(i.getValue() + "")));
		}
		
		BigDecimal sumOfX = new BigDecimal("0");
		for(Entry<Long, Long> i : data.entrySet()) {
			sumOfX = sumOfX.add(new BigDecimal("" + i.getKey()));
		}
		
		BigDecimal sumOfY = new BigDecimal("0");
		for(Entry<Long, Long> i : data.entrySet()) {
			sumOfY = sumOfY.add(new BigDecimal("" + i.getValue()));
		}
		
		BigDecimal sumOfXX = new BigDecimal("0");
		for(Entry<Long, Long> i : data.entrySet()) {
			long x = i.getKey();
			sumOfXX = sumOfXX.add(new BigDecimal("" + x).multiply(new BigDecimal("" + x)));
		}
		
		BigDecimal k = new BigDecimal("0");
		BigDecimal b = new BigDecimal("0");
		BigDecimal bn = new BigDecimal(n); 
		k = bn.multiply(sumOfXY).subtract(sumOfX.multiply(sumOfY)).divide(bn.multiply(sumOfXX).subtract(sumOfX), p, RoundingMode.HALF_UP);
		b = sumOfY.subtract(k.multiply(sumOfX)).divide(bn, p, RoundingMode.HALF_UP);
		
		System.out.println("Угловой коэффициент: " + k);
		System.out.println("Свободный член: " + b);
		
	}

}
