package com.ruleenginedemo.rule.model.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {
	public static final String SPLITLITERALS = " ";

	public static final String INTEGERTYPE = "integer";
	public static final String STRINGTYPE = "string";

	public static final String TIMEFORMAT = "yyyy-MM-dd hh:mm:ss";
	public static final String DATETIMETYPE = "datetime";
	public static final String DATETIMEFUTURE = "future";
	public static final String DATETIMEPAST = "past";

	public static final String[] STRINGTYPEVALUES = { "high", "medium", "low" ,"veryhigh" ,"verylow"};
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

	public static Timestamp convertStringToTimestamp(String stringTimeStamp) {
		try {
			DateFormat dateFormatter = new SimpleDateFormat(TIMEFORMAT);
			Date date = dateFormatter.parse(stringTimeStamp);
			return new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}

	public static Date convertStringToDate(String stringTimeStamp) {
		try {
			DateFormat dateFormatter = new SimpleDateFormat(TIMEFORMAT);
			return dateFormatter.parse(stringTimeStamp);
			
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}

}
