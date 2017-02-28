package com.bedrin.algebras.linear;

import java.util.ArrayList;

import com.bedrin.algebras.linear.interfaces.IEquation;

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
	
	public static void convertToLadderForm(LinearSystem sys) {
		for(int i = 0; i < sys.size() - 1; i++) {
			for(int j = i + 1; j < sys.size(); j++) {
				double temp = sys.get(i).findCoefficient(sys.get(i).getParameter(i), sys.get(j).getParameter(i));
				EquationDouble tmp = new EquationDouble(sys.get(i));
				tmp.mul(temp);
				sys.get(j).addEquation(tmp);
			}
		}
	}
	
	public static double calculateDeterminant(IEquation... eqs) {
		LinearSystem temp = new LinearSystem(eqs);
		convertToLadderForm(temp);
		double n = 1;
		for(int i = 0; i < temp.size(); i++) {
			n = n * temp.get(i).getParameter(i);
		}		
		return n;
	}
	
	public void calculateDeterminant() {
		convertToLadderForm(this.system);
		this.system.print();
		double n = 1;
		for(int i = 0; i < this.system.size(); i++) {
			n = n * this.system.get(i).getParameter(i);
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
