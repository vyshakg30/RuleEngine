package com.ruleenginedemo.rule.tree.impl;

import java.sql.Timestamp;

public class Signal {

	String sourceID;

	ValueType<Double> integerType;
	ValueType<String> stringType;
	ValueType<Timestamp> dateTimeType;
	ValueType<String> dateTimeStringType;

	public Signal(String sourceID) {
		this.sourceID = sourceID;
		integerType = new ValueType<Double>();
		stringType = new ValueType<String>();
		dateTimeType = new ValueType<Timestamp>();
		dateTimeStringType = new ValueType<String>();
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	public ValueType<Double> getIntegerValueType() {
		return integerType;
	}

	public void setIntegerValueType(ValueType<Double> integer) {
		this.integerType = integer;
	}

	public ValueType<String> getStringValueType() {
		return stringType;
	}

	public void setStringValueType(ValueType<String> string) {
		this.stringType = string;
	}

	public ValueType<Timestamp> getDateTimeValueType() {
		return dateTimeType;
	}

	public void setDateTimeValueType(ValueType<Timestamp> dateTime) {
		this.dateTimeType = dateTime;
	}

	public ValueType<String> getDateTimeInStringValueType() {
		return dateTimeStringType;
	}

	public void setDateTimeInStringValueType(ValueType<String> dateTimeString) {
		this.dateTimeStringType = dateTimeString;
	}

}
