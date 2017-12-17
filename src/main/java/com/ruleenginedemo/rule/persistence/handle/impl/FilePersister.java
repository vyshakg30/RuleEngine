package com.ruleenginedemo.rule.persistence.handle.impl;

import java.util.Set;

import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.rule.model.data.RuleCondition;
import com.ruleenginedemo.rule.persistence.handle.Persister;

public class FilePersister implements Persister {

	@Override
	public void persistRule(Set<RuleCondition> ruleConditions) {

		IOHelper.writeRuleConditionsToFile(ruleConditions);
	}
}
