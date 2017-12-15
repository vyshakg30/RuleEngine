package com.ruleenginedemo.rule.impl;

import java.util.Date;
import java.util.HashMap;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.DecisionTree;
import com.ruleenginedemo.rule.model.data.ConditionType;
import com.ruleenginedemo.rule.model.data.RuleCondition;
import com.ruleenginedemo.rule.model.data.StringHelper;
import com.ruleenginedemo.rule.tree.impl.Signal;
import com.ruleenginedemo.rule.tree.impl.ValueType;

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

		ValueType<String> dateTimeInString = signal.getDateTimeInStringValueType();
		String value = ruleCondition.getStringValue();

		if (ruleCondition.getLimitType() == ConditionType.FORBIDDEN) {
			dateTimeInString.getForbiddenValueSet().add(value);
			return true;
		}

		if (ruleCondition.getLimitType() == ConditionType.EXCLUSIVE) {
			dateTimeInString.getExclusivelyAllowedValueSet().add(value);
			return true;
		}

		return false;
	}

	private boolean addStringValueRule(RuleCondition ruleCondition, Signal signal) {

		ValueType<String> string = signal.getStringValueType();
		String value = ruleCondition.getStringValue();

		if (ruleCondition.getLimitType() == ConditionType.FORBIDDEN) {
			string.getForbiddenValueSet().add(value);
			return true;
		}

		if (ruleCondition.getLimitType() == ConditionType.EXCLUSIVE) {
			string.getExclusivelyAllowedValueSet().add(value);
			return true;
		}

		return false;
	}

	public boolean addIntegerValueRule(RuleCondition ruleCondition, Signal signal) {

		ValueType<Double> integer = signal.getIntegerValueType();
		Double val = ruleCondition.getIntegerValue();

		if (ruleCondition.getLimitType() == ConditionType.LOWERLIMIT) {

			Double lowerLimit = integer.getLowerLimitValue();
			if (lowerLimit == null || val < lowerLimit)
				integer.setLowerLimitValue(new Double(val.doubleValue()));
			return true;

		}

		if (ruleCondition.getLimitType() == ConditionType.UPPERLIMIT) {

			Double upperLimit = integer.getUpperLimitValue();

			if (upperLimit == null || val > upperLimit)
				integer.setUpperLimitValue(new Double(val.doubleValue()));

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

	public boolean violatesAnyRule(SignalSource querySignal) {

		Signal signalFromTree = signalsRoot.get(querySignal.getSourceID());

		if (signalFromTree == null)
			return false;

		switch (querySignal.getDataType()) {
		case StringHelper.INTEGERTYPE:
			return violatesAnyIntegerRule(signalFromTree, querySignal.getValue());
		case StringHelper.STRINGTYPE:
			return violatesAnyStringRule(signalFromTree, querySignal.getValue());
		case StringHelper.DATETIMETYPE:
			return violatesAnyDateTimeRule(signalFromTree, querySignal.getValue());

		}

		return false;
	}

	public boolean violatesAnyIntegerRule(Signal signalFromTree, String queryValue) {

		ValueType<Double> integerType = signalFromTree.getIntegerValueType();
		Double queryValueDouble = Double.parseDouble(queryValue);

		if (integerType.getExclusivelyAllowedValueSet().size() > 0
				&& !integerType.getExclusivelyAllowedValueSet().contains(queryValueDouble))
			return true;

		if (integerType.getForbiddenValueSet().contains(queryValueDouble))
			return true;

		if (integerType.getLowerLimitValue() != null && queryValueDouble > integerType.getLowerLimitValue())
			return true;

		if (integerType.getUpperLimitValue() != null && queryValueDouble < integerType.getUpperLimitValue())
			return true;

		return false;
	}

	public boolean violatesAnyStringRule(Signal signalFromTree, String queryValue) {

		ValueType<String> stringType = signalFromTree.getStringValueType();

		if (stringType.getExclusivelyAllowedValueSet().size() > 0
				&& !stringType.getExclusivelyAllowedValueSet().contains(queryValue))
			return true;

		if (stringType.getForbiddenValueSet().contains(queryValue))
			return true;

		return false;
	}

	public boolean violatesAnyDateTimeRule(Signal signalFromTree, String queryValue) {

		ValueType<String> dateStringType = signalFromTree.getDateTimeInStringValueType();
		Date queryDate = StringHelper.convertStringToDate(queryValue);
		Date currentDate = new Date();

		for (String dateRelatedValue : dateStringType.getExclusivelyAllowedValueSet())
			switch (dateRelatedValue) {

			case StringHelper.DATETIMEFUTURE:
				if (!queryDate.after(currentDate))
					return true;
				break;

			case StringHelper.DATETIMEPAST:
				if (!queryDate.before(currentDate))
					return true;

			}

		for (String dateRelatedValue : dateStringType.getForbiddenValueSet())
			switch (dateRelatedValue) {

			case StringHelper.DATETIMEFUTURE:
				if (queryDate.after(currentDate))
					return true;
				break;
			case StringHelper.DATETIMEPAST:
				if (queryDate.before(currentDate))
					return true;

			}

		return false;
	}

}
