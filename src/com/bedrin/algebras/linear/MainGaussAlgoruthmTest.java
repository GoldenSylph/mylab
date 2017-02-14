package com.bedrin.algebras.linear;

public class MainGaussAlgoruthmTest {

	public static void main(String[] args) {
		
		Equation[] test = {
			new Equation(1, 0, 1),
			new Equation(0, 1, 1),
			new Equation(1, 1, 0)
		};
		
		LinearSystem ls = new LinearSystem(test);
		ls.print();
		GaussAlgorithm ga = new GaussAlgorithm(ls);
		ga.calculateDeterminant();
		System.out.println(ga.getDeterminant());
		
		
	}
	
}
