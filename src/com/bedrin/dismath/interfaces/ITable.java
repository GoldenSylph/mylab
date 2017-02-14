package com.bedrin.dismath.interfaces;

import com.bedrin.dismath.exceptions.Command;

public interface ITable {

	void forOne(Integer pos, int state, StringBuffer src) throws Command;
	void forZero(Integer pos, int state, StringBuffer src) throws Command;
	void forEmpty(Integer pos, int state, StringBuffer src) throws Command;
	
}
