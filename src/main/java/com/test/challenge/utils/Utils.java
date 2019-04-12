package com.test.challenge.utils;

public class Utils {
	
	/**
	 * This method is to round double to specific decimal places
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	/**
	 * This method is to convert rate from integer number to (***) stars format
	 */
	public static String getStarsRate(int rate) {
		String result = "";
		for (int i = 0; i < rate; i++) {
			result += "*";
		}
		return result;
	}

}
