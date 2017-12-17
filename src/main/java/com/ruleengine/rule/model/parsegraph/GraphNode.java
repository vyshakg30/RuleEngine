package com.ruleengine.rule.model.parsegraph;

import com.ruleengine.rule.model.data.RuleCondition;

public interface GraphNode {
	public RuleCondition formRuleCondition(String value, String sourceID);

}
