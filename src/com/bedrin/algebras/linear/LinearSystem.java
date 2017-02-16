package com.bedrin.algebras.linear;

import java.util.ArrayList;
import java.util.List;

import com.bedrin.algebras.linear.interfaces.IEquation;

public class LinearSystem implements Cloneable {
	
	private List<IEquation> items;
	
	public LinearSystem(IEquation[] eqs) {
		this.items = new ArrayList<IEquation>();
		for (IEquation t : eqs) {
			this.items.add(t);
		}
	}

	public IEquation get(int index) {
		return this.items.get(index);
	}
	
	public void push(IEquation item) {
		this.items.add(item);
	}
	
	public int size() {
		return this.items.size();
	}
	
	public double parameterAt(int i, int j) {
		return this.items.get(i).getParameter(j);
	}
	
	public void print(){
        for (int i = 0; i < items.size(); i++){
            IEquation temp = items.get(i);
            String s = "";
            for (int j = 0; j < temp.size(); j++){
                s += String.format("%s; %s", items.get(i).getParameter(j), "\t");
            }
            System.out.println(s);
        } 
        System.out.println("");	
    }
	
}
