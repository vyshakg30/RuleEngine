package com.ruleenginedemo.rule.model.parsegraph;

import com.ruleenginedemo.rule.model.data.RuleCondition;

public interface GraphNode {
	public RuleCondition formRuleCondition(String value, String sourceID);

}
