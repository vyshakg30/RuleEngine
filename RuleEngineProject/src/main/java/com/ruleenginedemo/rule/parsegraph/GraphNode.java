package com.ruleenginedemo.rule.parsegraph;

import com.ruleenginedemo.rule.data.RuleCondition;

public interface GraphNode {
	public RuleCondition formRuleCondition(String value, String sourceID);

}
