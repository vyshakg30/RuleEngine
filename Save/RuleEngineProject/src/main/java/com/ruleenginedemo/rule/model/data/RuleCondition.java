package com.ruleenginedemo.rule.model.data;

public class RuleCondition {

	ConditionType dataType;
	ConditionType limitType;

	String sourceID;

	Double integerValue;
	String StringValue;
	// Timestamp dateTimeValue;

	public RuleCondition() {
		super();

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

	@Override
	public String toString() {
		return "RuleCondition [dataType=" + dataType + ", limitType=" + limitType + ", sourceID=" + sourceID
				+ ", integerValue=" + integerValue + ", StringValue=" + StringValue + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public int hashCode() {

		return (sourceID == null ? 0 : sourceID.hashCode()) + (integerValue == null ? 0 : integerValue.hashCode())
				+ (StringValue == null ? 0 : StringValue.hashCode()) + (dataType == null ? 0 : dataType.hashCode())
				+ (limitType == null ? 0 : limitType.hashCode());

	}

}
