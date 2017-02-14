package com.bedrin.dismath;

import com.bedrin.dismath.mt.IncrementFunction;
import com.bedrin.dismath.mt.TuringMachine;

public class Main {

	public static void main(String[] args) {
		TuringMachine m = new TuringMachine(new IncrementFunction(), "^^^1111^^^");
		m.work();
	}

}
