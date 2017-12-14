package com.example.ruleenginedemo.data;

public class StringHelper {
	public static final String SPLITLITERALS = " ,:.";

	public static final String[] STRINGTYPEVALUES = { "high", "medium", "low" };
	public static final String[] DATETIMETYPEVALUES = { "future", "past" };
	public static final String[] POSITIVEWORDS = { "should", "must", "always" };
	public static final String[] NEGATIVEWORDS = { "shouldn't", "mustn't", "never", "not", "can't" };

	public static final String[] UPPERLIMITWORDS = { "more", "additional", "higher", "above", "beyound", "greater" };
	public static final String[] LOWERLIMITWORDS = { "less", "lower", "below", "under" };
	public static final String[] TRICKYWORDS = { "only", "exclusively", "just" };

	public static boolean isAlphaNumeric(String token) {
		if (token.matches("^[a-zA-Z0-9]*$"))
			return true;

		return false;
	}

	public static boolean isNumeric(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
