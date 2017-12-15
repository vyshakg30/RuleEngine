package com.example.ruleenginedemo.data.graph;

import com.example.ruleenginedemo.data.RuleCondition;

public interface GraphNode {
	public RuleCondition formRuleCondition(String value, String sourceID);

}
