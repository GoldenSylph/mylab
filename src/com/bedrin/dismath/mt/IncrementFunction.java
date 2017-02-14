package com.bedrin.dismath.mt;

import com.bedrin.dismath.exceptions.Command;
import com.bedrin.dismath.interfaces.ITable;

public class IncrementFunction implements ITable {

	@Override
	public void forOne(Integer pos, int state, StringBuffer src) throws Command {
		switch (state) {
		
			case 0: 
				throw Command.CHANGE_CARET_INC;
			case 1:
				src.setCharAt(pos, '0');
				throw Command.CHANGE_CARET_DEC;
				
			default:
				throw new RuntimeException("Unknown state!");
		}
	}

	@Override
	public void forZero(Integer pos, int state, StringBuffer src) throws Command {
		switch (state) {
		
			case 0: 
				throw Command.CHANGE_CARET_INC;
			case 1:
				src.setCharAt(pos, '1');
				throw Command.STOP;
				
			default:
				throw new RuntimeException("Unknown state!");
		}

	}
	
	@Override
	public void forEmpty(Integer pos, int state, StringBuffer src) throws Command {
		switch (state) {
			
			case 0: 
				throw new Command(-1, 1, false);
			case 1:
				src.setCharAt(pos, '1');
				throw Command.STOP;
	
			default:
				throw new RuntimeException("Unknown state!");
		}
		
	}

}
