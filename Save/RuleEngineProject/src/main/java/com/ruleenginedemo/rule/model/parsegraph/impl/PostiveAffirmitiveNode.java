package com.ruleenginedemo.rule.model.parsegraph.impl;

import java.util.Arrays;

import com.ruleenginedemo.rule.model.data.ConditionType;
import com.ruleenginedemo.rule.model.data.RuleCondition;
import com.ruleenginedemo.rule.model.function.StringHelper;

public class PostiveAffirmitiveNode extends SentenceNode {

	public PostiveAffirmitiveNode() {
		super();

	}

	public PostiveAffirmitiveNode(String name) {
		super(name);

	}

	@Override
	public RuleCondition formRuleCondition(String value, String sourceID) {

		if (StringHelper.isNumeric(value)) {

			Double doubleValue = Double.parseDouble(value);

			RuleCondition ruleCondition = new RuleCondition();

			ruleCondition.setSourceID(sourceID);
			ruleCondition.setDataType(ConditionType.INTEGER);
			ruleCondition.setLimitType(ConditionType.EXCLUSIVE);
			ruleCondition.setIntegerValue(doubleValue);

			return ruleCondition;

		}

		if (Arrays.asList(StringHelper.STRINGTYPEVALUES).contains(value)) {

			RuleCondition ruleCondition = new RuleCondition();

			ruleCondition.setSourceID(sourceID);
			ruleCondition.setDataType(ConditionType.STRING);
			ruleCondition.setLimitType(ConditionType.EXCLUSIVE);
			ruleCondition.setStringValue(value);

			return ruleCondition;

		}

		if (Arrays.asList(StringHelper.DATETIMETYPEVALUES).contains(value)) {

			RuleCondition ruleCondition = new RuleCondition();

			ruleCondition.setSourceID(sourceID);
			ruleCondition.setDataType(ConditionType.DATETIME);
			ruleCondition.setLimitType(ConditionType.EXCLUSIVE);
			ruleCondition.setStringValue(value);

			return ruleCondition;

		}

		return null;
	}

}
