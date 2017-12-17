package com.ruleengine.input.data;

public class SignalSource {

	public String signal;
	public String value;
	public String value_type;

	public SignalSource(String sourceID, String value, String dataType) {
		super();
		this.signal = sourceID;
		this.value = value;
		this.value_type = dataType;
	}

	public String getSignal() {
		return signal.trim().toLowerCase();
	}

	public void setSignal(String sourceID) {
		this.signal = sourceID;
	}

	public String getValue_type() {
		return value_type.trim().toLowerCase();
	}

	public void setValue_type(String dataType) {
		this.value_type = dataType;
	}

	public String getValue() {
		return value.trim().toLowerCase();
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[signal=" + signal + ", value=" + value + ", value_type=" + value_type + "]";
	}

}
