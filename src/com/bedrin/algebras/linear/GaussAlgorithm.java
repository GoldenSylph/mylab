package com.bedrin.algebras.linear;

import java.util.ArrayList;

public class GaussAlgorithm {

	private LinearSystem system;
	
	private ArrayList<Double> answers;
	
	private double determinant;
	
	public GaussAlgorithm(LinearSystem system) {
		this.system = system;
		this.answers = new ArrayList<Double>();
	}
	
	public void proceedForwardWay() {
		check();
		convertToLadderForm(this.system);
		this.system.print();
	}
	
	private void convertToLadderForm(LinearSystem system) {
		for(int i = 0; i < system.size() - 1; i++) {
			for(int j = i + 1; j < system.size(); j++) {
				double temp = system.get(i).findCoefficient(system.get(i).getParameter(i), system.get(j).getParameter(i));
				Equation tmp = new Equation(system.get(i));
				tmp.mul(temp);
				system.get(j).addEquation(tmp);
			}
		}
	}
	
	public void calculateDeterminant() {
		LinearSystem temp = new LinearSystem();
		this.system.copyTo(temp);
		convertToLadderForm(temp);
		temp.print();
		double n = 1;
		for(int i = 0; i < temp.size(); i++) {
			n = n * temp.get(i).getParameter(i);
		}		
		this.determinant = n;
		
	}
	
	public double getDeterminant() {
		return this.determinant;
	}
	
	
	private void check() {
		if (system == null) {
			throw new NullPointerException("LinearSystem instance equal null");
		}
		if (system.size() < 2) {
			throw new ArithmeticException("Incorrect system for Gauss Method");
		}
	}
	
	public ArrayList<Double> getAnswers() {
		return this.answers;
	}
	
}
