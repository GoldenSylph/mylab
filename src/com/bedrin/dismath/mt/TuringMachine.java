package com.bedrin.dismath.mt;

import com.bedrin.dismath.exceptions.Command;
import com.bedrin.dismath.interfaces.ITable;

public class TuringMachine {
	
	private int currentState;
	private ITable instructions;
	private StringBuffer src;
	
	public TuringMachine(ITable instructions, String source) {
		this.currentState = 0;
		this.instructions = instructions;
		this.src = new StringBuffer(source);
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
						throw new RuntimeException("Unknown Symbol found in " + start + "position: " + t);
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
