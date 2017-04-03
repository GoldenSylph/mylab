package com.bedrin.algebras.linear;

import java.util.Arrays;

public class MainGaussAlgoruthmTest {

	public static void main(String[] args) {
		
		EquationDouble[] test = {
			new EquationDouble(1, 0, 1, 5),
			new EquationDouble(0, 1, 1, 3),
			new EquationDouble(1, 1, 0, 8),
			new EquationDouble(1, 1, 0, 1)
		};
		
		System.out.println(Arrays.toString(test));
		System.out.println(GaussAlgorithm.calculateDeterminant(test));
	}
	
}
