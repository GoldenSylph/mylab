package com.bedrin.dismath.exceptions;

public class Command extends Exception {

	public static final Command STOP = new Command(0, 0, true);
	public static final Command CHANGE_STATE_INC = new Command(0, 1, false);
	public static final Command CHANGE_STATE_DEC = new Command(0, -1, false);
	public static final Command CHANGE_CARET_INC = new Command(1, 0, false);
	public static final Command CHANGE_CARET_DEC = new Command(-1, 0, false);
	
	private static final long serialVersionUID = 8760594396592817172L;

	private int pos;
	private int state;
	private boolean end;
	
	public Command(int pos, int state, boolean end) {
		this.setPosition(pos);
		this.setState(state);
		this.setEnd(end);
	}

	public int getPosition() {
		return pos;
	}

	public void setPosition(int pos) {
		this.pos = pos;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
}
