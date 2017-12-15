package com.ruleenginedemo.input.data;

public class SignalSource {

	String sourceID;
	String value;
	String dataType;

	public SignalSource(String sourceID, String value, String dataType) {
		super();
		this.sourceID = sourceID;
		this.value = value;
		this.dataType = dataType;
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
