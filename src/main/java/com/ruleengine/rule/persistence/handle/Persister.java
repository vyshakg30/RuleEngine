package com.ruleengine.rule.persistence.handle;

import java.util.Set;

import com.ruleengine.rule.model.data.RuleCondition;

public interface Persister {

	public void persistRule(Set<RuleCondition> ruleConditions);

}
