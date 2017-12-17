package com.ruleenginedemo.rule.model.parsegraph.impl;

import com.ruleenginedemo.input.function.StringHelper;
import com.ruleenginedemo.rule.model.data.ConditionType;
import com.ruleenginedemo.rule.model.data.RuleCondition;

public class LowerLimitHandleNode extends SentenceNode {

	public LowerLimitHandleNode() {
		super();
	}

	public LowerLimitHandleNode(String name) {
		super(name);
	}

	@Override
	public RuleCondition formRuleCondition(String value, String sourceID) {

		if (!StringHelper.isNumeric(value))
			return null;
		
		
		Double doubleValue = Double.parseDouble(value);

		RuleCondition ruleCondition = new RuleCondition();
		ruleCondition.setSourceID(sourceID);
		ruleCondition.setDataType(ConditionType.INTEGER);
		ruleCondition.setLimitType(ConditionType.LOWERLIMIT);
		ruleCondition.setIntegerValue(doubleValue);

		return ruleCondition;

	}

}
