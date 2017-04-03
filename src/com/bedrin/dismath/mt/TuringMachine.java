package com.bedrin.dismath.mt;

import com.bedrin.dismath.exceptions.Command;
import com.bedrin.dismath.interfaces.IFunction;

public class TuringMachine {
	
	private int currentState;
	private IFunction instructions;
	private StringBuffer src;
	
	public TuringMachine(IFunction instructions, String source, int beginState) {
		this.currentState = beginState;
		this.instructions = instructions;
		this.src = new StringBuffer(source);
	}
	
	public TuringMachine(IFunction instructions, String source) {
		this(instructions, source, 0);
	}
	
	public void work() {
		System.out.println("Work is started.");
		System.out.println(src);
		Integer start = 3;
		while (true) {
			Character t = src.charAt(start);
			try {
				switch (t) {
					case '^':
						this.instructions.forEmpty(start, currentState, src);
						break;
					case '0':
						this.instructions.forZero(start, currentState, src);
						break;
					case '1':
						this.instructions.forOne(start, currentState, src);
						break;
					default:
						throw new RuntimeException("Unknown symbol found in " + start + " position: " + t);
				}
			} catch (Command e) {
				currentState += e.getState();
				start += e.getPosition();
				if(e.isEnd()) {
					break;
				}
			}
		}
		System.out.println(src);
		System.out.println("Work is ended.");
	}

}
