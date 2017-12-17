package com.ruleengine.rule.model.parsegraph.impl;

import com.ruleengine.input.function.StringHelper;
import com.ruleengine.rule.model.data.ConditionType;
import com.ruleengine.rule.model.data.RuleCondition;

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
