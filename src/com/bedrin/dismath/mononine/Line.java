package com.bedrin.dismath.mononine;

public class Line {

	private byte[] values;
	
	public Line(short value, byte length) {
		this.values = new byte[length];
		String s = Integer.toBinaryString(value);
		for(int i = 0; i < this.values.length; i++) {
			if(s.length() - i > 0) {
				this.values[i] = Byte.parseByte(s.substring(i, i + 1));
			} else {
				this.values[i] = 0;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("(");
		for(byte i : this.values) {
			buffer.append(i + "");
		}
		buffer.append(")");
		return buffer.toString();
	}
	
	public boolean isMono() {
		boolean r = false;
		return r;
	}
	
}
