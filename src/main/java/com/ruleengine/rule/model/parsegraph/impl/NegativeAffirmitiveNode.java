package com.ruleengine.rule.model.parsegraph.impl;

import java.util.Arrays;

import com.ruleengine.input.function.StringHelper;
import com.ruleengine.rule.model.data.ConditionType;
import com.ruleengine.rule.model.data.RuleCondition;

public class NegativeAffirmitiveNode extends SentenceNode {

	public NegativeAffirmitiveNode() {
		super();

	}

	public NegativeAffirmitiveNode(String name) {
		super(name);

	}

	@Override
	public RuleCondition formRuleCondition(String value, String sourceID) {

		if (StringHelper.isNumeric(value)) {

			Double doubleValue = Double.parseDouble(value);
			RuleCondition ruleCondition = new RuleCondition();

			ruleCondition.setSourceID(sourceID);
			ruleCondition.setDataType(ConditionType.INTEGER);
			ruleCondition.setLimitType(ConditionType.FORBIDDEN);
			ruleCondition.setIntegerValue(doubleValue);

			return ruleCondition;

		}

		if (Arrays.asList(StringHelper.STRINGTYPEVALUES).contains(value)) {

			RuleCondition ruleCondition = new RuleCondition();

			ruleCondition.setSourceID(sourceID);
			ruleCondition.setDataType(ConditionType.STRING);
			ruleCondition.setLimitType(ConditionType.FORBIDDEN);
			ruleCondition.setStringValue(value);

			return ruleCondition;

		}

		if (Arrays.asList(StringHelper.DATETIMETYPEVALUES).contains(value)) {

			RuleCondition ruleCondition = new RuleCondition();

			ruleCondition.setSourceID(sourceID);
			ruleCondition.setDataType(ConditionType.DATETIME);
			ruleCondition.setLimitType(ConditionType.FORBIDDEN);
			ruleCondition.setStringValue(value);

			return ruleCondition;

		}

		return null;
	}

}
