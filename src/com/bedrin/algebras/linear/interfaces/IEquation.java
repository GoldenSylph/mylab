package com.bedrin.algebras.linear.interfaces;

public interface IEquation extends Cloneable {
	void addEquation(IEquation item);
	void mul(double coefficient);
	double findCoefficient(double a, double b);
	double getParameter(int index);
	int size();
}
