package com.qa.Utilities;

public class TimeUtiles {

	private static final int SHORT_TIME = 5000;
	private static final int MEDIUM_TIME = 10000;
	private static final int LONG_TIME = 15000;
	private static final int LONGER_TIME = 20000;

	public static void shortWait() {
			try {
				Thread.sleep(SHORT_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void MediumWait() {
		try {
			Thread.sleep(MEDIUM_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static void longWait() {
		try {
			Thread.sleep(LONG_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public static void longerWait() {
		try {
			Thread.sleep(LONGER_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
