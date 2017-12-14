package com.example.ruleenginedemo.data;

import java.sql.Timestamp;

public class Signal {

	String sourceID;

	ValueType<Double> integer;
	ValueType<String> string;
	ValueType<Timestamp> dateTime;

	public Signal(String sourceID) {
		this.sourceID = sourceID;
		integer = new ValueType<Double>();
		string = new ValueType<String>();
		dateTime = new ValueType<Timestamp>();
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	public ValueType<Double> getInteger() {
		return integer;
	}

	public void setInteger(ValueType<Double> integer) {
		this.integer = integer;
	}

	public ValueType<String> getString() {
		return string;
	}

	public void setString(ValueType<String> string) {
		this.string = string;
	}

	public ValueType<Timestamp> getDateTime() {
		return dateTime;
	}

	public void setDateTime(ValueType<Timestamp> dateTime) {
		this.dateTime = dateTime;
	}

}
