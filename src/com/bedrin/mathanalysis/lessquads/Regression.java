package com.bedrin.mathanalysis.lessquads;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public class Regression {

	private static BigDecimal a;
	private static BigDecimal b;
	
	public static void main(String[] args) {
		
		HashMap<BigDecimal, BigDecimal> data = new HashMap<BigDecimal, BigDecimal>();
		Scanner s = new Scanner(System.in);
		System.out.println("Введите количество исходных данных:");
		BigDecimal n = s.nextBigDecimal();
		System.out.println("Введите точность вычислений:");
		byte k = s.nextByte();
		System.out.println("Введите исходные данные:");
		for (BigDecimal i = BigDecimal.ZERO; i.compareTo(n) == -1; i = i.add(BigDecimal.ONE)) {
			data.put(s.nextBigDecimal(), s.nextBigDecimal());
		}
		s.close();
		
		BigDecimal sumOfXY = BigDecimal.ZERO;
		for(Entry<BigDecimal, BigDecimal> i : data.entrySet()) {
			sumOfXY = sumOfXY.add(i.getKey().multiply(i.getValue()));
		}
		
		BigDecimal sumOfX = BigDecimal.ZERO;
		for(Entry<BigDecimal, BigDecimal> i : data.entrySet()) {
			sumOfX = sumOfX.add(i.getKey());
		}
		
		BigDecimal sumOfY = BigDecimal.ZERO;
		for(Entry<BigDecimal, BigDecimal> i : data.entrySet()) {
			sumOfY = sumOfY.add(i.getValue());
		}
		
		BigDecimal sumOfXX = BigDecimal.ZERO;
		for(Entry<BigDecimal, BigDecimal> i : data.entrySet()) {
			BigDecimal t = i.getKey();
			sumOfXX = sumOfXX.add(t.multiply(t));
		}
		
		BigDecimal middleOfY = sumOfY.divide(n, k, RoundingMode.HALF_UP);
		
		BigDecimal temp = n.multiply(sumOfXX).subtract(sumOfX.multiply(sumOfX));
		a = n.multiply(sumOfXY).subtract(sumOfX.multiply(sumOfY))
				.divide(temp, k, RoundingMode.HALF_UP);
		b = sumOfY.multiply(sumOfXX).subtract(sumOfXY.multiply(sumOfX)).divide(temp, k, RoundingMode.HALF_UP);
		
		BigDecimal sumOfSubstractionsYMiddleYSquare = BigDecimal.ZERO; 
		for(Entry<BigDecimal, BigDecimal> i : data.entrySet()) {
			BigDecimal t = i.getValue().subtract(middleOfY);
			sumOfSubstractionsYMiddleYSquare = sumOfSubstractionsYMiddleYSquare.add(t.multiply(t));
		}
		
		BigDecimal sumOfSubstracionsYYWithWaveSquare = BigDecimal.ZERO;
		for(Entry<BigDecimal, BigDecimal> i : data.entrySet()) {
			BigDecimal t = i.getValue().subtract(yWithWave(i.getKey()));
			sumOfSubstracionsYYWithWaveSquare = sumOfSubstracionsYYWithWaveSquare.add(t.multiply(t));
		}
		
		BigDecimal rSquare = (sumOfSubstractionsYMiddleYSquare.subtract(sumOfSubstracionsYYWithWaveSquare))
				.divide(sumOfSubstractionsYMiddleYSquare, k, RoundingMode.HALF_UP);
		
		Apfloat r = ApfloatMath.sqrt(new Apfloat(rSquare, k));

		System.out.println("Угловой коэффициент прямой регрессии - " + a);
		System.out.println("Свободный член уравнения прямой регрессии - " + b);
		System.out.println("Коэффициент корелляции - " + r);
		System.out.println("Ожидаемый порог - " + (0.94 - 0.001 * 63));
	}
	
	private static BigDecimal yWithWave(BigDecimal x) {
		return a.multiply(x).add(b);
	}

}
