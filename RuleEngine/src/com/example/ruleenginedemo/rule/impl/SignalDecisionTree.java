package com.example.ruleenginedemo.rule.impl;

import java.sql.Timestamp;
import java.util.HashMap;

import com.example.ruleenginedemo.data.ConditionType;
import com.example.ruleenginedemo.data.RuleCondition;
import com.example.ruleenginedemo.data.Signal;
import com.example.ruleenginedemo.data.ValueType;
import com.example.ruleenginedemo.rule.DecisionTree;

public class SignalDecisionTree implements DecisionTree {

	HashMap<String, Signal> signalsRoot;

	public SignalDecisionTree() {
		signalsRoot = new HashMap<>();
	}

	public boolean addRule(RuleCondition ruleCondition) {

		String sourceID = ruleCondition.getSourceID();
		Signal signal = signalsRoot.get(sourceID);

		if (signal == null) {
			signal = new Signal(sourceID);
			signalsRoot.put(sourceID, signal);
		}

		switch (ruleCondition.getDataType()) {
		case INTEGER:
			return addIntegerValueRule(ruleCondition, signal);
		case STRING:
			return addStringValueRule(ruleCondition, signal);
		case DATETIME:
			return addDateTimeValueRule(ruleCondition, signal);
		default:
			break;
		}

		return false;

	}

	private boolean addDateTimeValueRule(RuleCondition ruleCondition, Signal signal) {
		ValueType<Timestamp> dateTime;
		return false;
	}

	private boolean addStringValueRule(RuleCondition ruleCondition, Signal signal) {
		ValueType<String> string;
		return false;
	}

	public boolean addIntegerValueRule(RuleCondition ruleCondition, Signal signal) {

		ValueType<Double> integer = signal.getInteger();
		Double val = ruleCondition.getIntegerValue();

		if (ruleCondition.getLimitType() == ConditionType.LOWER) {

			Double lowerLimit = integer.getLowerLimitValue();

			if (lowerLimit == null || val < lowerLimit)
				lowerLimit = new Double(val.doubleValue());

			return true;
		}

		if (ruleCondition.getLimitType() == ConditionType.HIGHER) {

			Double upperLimit = integer.getUpperLimitValue();

			if (upperLimit == null || val > upperLimit)
				upperLimit = new Double(val.doubleValue());

			return true;
		}

		if (ruleCondition.getLimitType() == ConditionType.FORBIDDEN) {
			integer.getForbiddenValueSet().add(ruleCondition.getIntegerValue());
			return true;
		}

		if (ruleCondition.getLimitType() == ConditionType.EXCLUSIVE) {
			integer.getExclusivelyAllowedValueSet().add(ruleCondition.getIntegerValue());
			return true;
		}

		return false;
	}

}
