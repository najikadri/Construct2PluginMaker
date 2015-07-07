package com.lbg.c2;

public class C2Launcher {
	
	private static C2Frame frame;

	public static void main (String args[]) {
		setFrame(new C2Frame ());
	}

	public static C2Frame getFrame() {
		return frame;
	}

	public static void setFrame(C2Frame frame) {
		C2Launcher.frame = frame;
	}

}
