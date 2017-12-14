package com.example.ruleenginedemo.data.graph;

import com.example.ruleenginedemo.data.ConditionType;
import com.example.ruleenginedemo.data.RuleCondition;
import com.example.ruleenginedemo.data.StringHelper;

public class LowerLimitHandleNode extends SentenceNode {

	public LowerLimitHandleNode() {
		super();
	}

	public LowerLimitHandleNode(String name) {
		super(name);
	}

	@Override
	public RuleCondition formRule(String value, String sourceID) {

		if (!StringHelper.isNumeric(value))
			return null;

		Double doubleValue = Double.parseDouble(value);

		RuleCondition ruleCondition = new RuleCondition();

		ruleCondition.setSourceID(sourceID);
		ruleCondition.setDataType(ConditionType.INTEGER);
		ruleCondition.setLimitType(ConditionType.LOWER);
		ruleCondition.setIntegerValue(doubleValue);

		return ruleCondition;

	}

}
