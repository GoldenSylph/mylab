package com.bedrin.dismath.mt;

import com.bedrin.dismath.exceptions.Command;
import com.bedrin.dismath.interfaces.IFunction;

public class FUFunction implements IFunction {

	@Override
	public void forOne(Integer pos, int state, StringBuffer src) throws Command {
		switch (state) {
		case 0: 
			src.deleteCharAt(pos);
			src.insert(pos, "FUCK^YOU");
			throw Command.STOP;
		default:
			throw new RuntimeException("Unknown state!");
		}
	}

	@Override
	public void forZero(Integer pos, int state, StringBuffer src) throws Command {
		switch (state) {
		case 0: 
			throw Command.STOP;
		default:
			throw new RuntimeException("Unknown state!");
		}
	}

	@Override
	public void forEmpty(Integer pos, int state, StringBuffer src) throws Command {
		switch (state) {
		case 0: 
			throw Command.STOP;
		default:
			throw new RuntimeException("Unknown state!");
		}
	}

}
