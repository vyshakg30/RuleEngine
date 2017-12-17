package com.ruleenginedemo.rule.persistence.handle;

import java.util.Set;

import com.ruleenginedemo.rule.model.data.RuleCondition;

public interface Persister {

	public void persistRule(Set<RuleCondition> ruleConditions);

}
