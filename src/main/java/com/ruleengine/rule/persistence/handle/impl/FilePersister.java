package com.ruleengine.rule.persistence.handle.impl;

import java.util.Set;

import com.ruleengine.input.function.IOHelper;
import com.ruleengine.rule.model.data.RuleCondition;
import com.ruleengine.rule.persistence.handle.Persister;

public class FilePersister implements Persister {

	@Override
	public void persistRule(Set<RuleCondition> ruleConditions) {

		IOHelper.writeRuleConditionsToFile(ruleConditions);
	}
}
