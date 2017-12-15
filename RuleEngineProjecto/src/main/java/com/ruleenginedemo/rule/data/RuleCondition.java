package com.ruleenginedemo.rule.data;

import java.sql.Timestamp;

public class RuleCondition {

	ConditionType dataType;
	ConditionType limitType;

	String sourceID;

	Double integerValue;
	String StringValue;
	Timestamp dateTimeValue;

	public RuleCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConditionType getDataType() {
		return dataType;
	}

	public void setDataType(ConditionType dataType) {
		this.dataType = dataType;
	}

	public ConditionType getLimitType() {
		return limitType;
	}

	public void setLimitType(ConditionType limitType) {
		this.limitType = limitType;
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	public Double getIntegerValue() {
		return integerValue;
	}

	public void setIntegerValue(Double integerValue) {
		this.integerValue = integerValue;
	}

	public String getStringValue() {
		return StringValue;
	}

	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}

	public Timestamp getDateTimeValue() {
		return dateTimeValue;
	}

	public void setDateTimeValue(Timestamp dateTimeValue) {
		this.dateTimeValue = dateTimeValue;
	}

}
