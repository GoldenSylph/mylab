package com.bedrin.algebras.linear;

import java.util.ArrayList;

import com.bedrin.algebras.exceptions.EqualityException;
import com.bedrin.algebras.linear.interfaces.IEquation;

public class EquationDouble implements IEquation {

	private ArrayList<Double> parametres;
	
	public EquationDouble(double... parametres) {
		this.parametres = new ArrayList<Double>();
		for (double d : parametres) {
			this.parametres.add(d);
		}
	}
	
	public EquationDouble(IEquation e) {
		this.parametres = new ArrayList<Double>();
		for (int i = 0; i < e.size(); i++) {
			this.parametres.add(e.getParameter(i));
		}
	}
	
	@Override
	public void addEquation(IEquation item) {
		if(size() != item.size()) {
			throw new EqualityException();
		}
		for(int i = 0; i < this.parametres.size(); i++) {
			this.parametres.set(i, this.getParameter(i) + item.getParameter(i));
		}
	}

	@Override
	public void mul(double coefficient) {
		for(int i = 0; i < this.parametres.size(); i++) {
			this.parametres.set(i, this.getParameter(i) * coefficient);
		}
	}

	@Override
	public double findCoefficient(double a, double b) {
		if(a == 0d) return 1d;
		return -b / a;
	}

	@Override
	public double getParameter(int index) {
		return this.parametres.get(index);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Double p : parametres) {
			sb.append(p).append(" ");
		}
		return sb.toString();
	}

	@Override
	public int size() {
		return this.parametres.size();
	}

}
