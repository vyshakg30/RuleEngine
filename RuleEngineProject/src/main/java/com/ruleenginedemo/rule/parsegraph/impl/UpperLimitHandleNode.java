package com.ruleenginedemo.rule.parsegraph.impl;

import com.ruleenginedemo.rule.data.ConditionType;
import com.ruleenginedemo.rule.data.RuleCondition;
import com.ruleenginedemo.rule.data.StringHelper;

public class UpperLimitHandleNode extends SentenceNode {

	public UpperLimitHandleNode(String name) {
		super(name);

	}

	public UpperLimitHandleNode() {
		super();

	}

	@Override
	public RuleCondition formRuleCondition(String value, String sourceID) {

		if (!StringHelper.isNumeric(value))
			return null;

		Double doubleValue = Double.parseDouble(value);

		RuleCondition ruleCondition = new RuleCondition();

		ruleCondition.setSourceID(sourceID);
		ruleCondition.setDataType(ConditionType.INTEGER);
		ruleCondition.setLimitType(ConditionType.UPPERLIMIT);
		ruleCondition.setIntegerValue(doubleValue);

		return ruleCondition;
	}

}