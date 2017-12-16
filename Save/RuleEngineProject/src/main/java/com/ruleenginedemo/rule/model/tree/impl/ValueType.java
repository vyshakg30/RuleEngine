package com.ruleenginedemo.rule.model.tree.impl;

import java.util.HashSet;
import java.util.Set;

public class ValueType<T> {

	T lowerLimitValue, upperLimitValue;
	Set<T> forbiddenValues, exclusivelyAllowedValues;

	public ValueType() {
		forbiddenValues = new HashSet<>();
		exclusivelyAllowedValues = new HashSet<>();

	}

	public T getLowerLimitValue() {
		return lowerLimitValue;
	}

 	public void setLowerLimitValue(T lowerLimitValue) {
		
		this.lowerLimitValue = lowerLimitValue;
	}

	public T getUpperLimitValue() {
		return upperLimitValue;
	}

	public void setUpperLimitValue(T upperLimitValue) {
		this.upperLimitValue = upperLimitValue;
	}

	public Set<T> getForbiddenValueSet() {
		return forbiddenValues;
	}

	public void setForbiddenValues(Set<T> forbiddenValues) {
		this.forbiddenValues = forbiddenValues;
	}

	public Set<T> getExclusivelyAllowedValueSet() {
		return exclusivelyAllowedValues;
	}

	public void setExclusivelyAllowedValues(Set<T> exclusivelyAllowedValues) {
		this.exclusivelyAllowedValues = exclusivelyAllowedValues;
	}

}
