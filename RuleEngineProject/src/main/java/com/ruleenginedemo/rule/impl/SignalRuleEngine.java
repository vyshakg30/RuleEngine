package com.ruleenginedemo.rule.impl;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.model.data.RuleCondition;

public class SignalRuleEngine implements RuleEngine {

	SignalDecisionTree signalDecisionTree;
	SentenceParseGraph sentenceParseGraph;

	public SignalRuleEngine() {
		signalDecisionTree = new SignalDecisionTree();
		sentenceParseGraph = new SentenceParseGraph();
	}

	public boolean addRule(String ruleSentence) {

		RuleCondition ruleCondition;
		ruleCondition = sentenceParseGraph.getRuleCondition(ruleSentence);
		if (ruleCondition != null)
			return signalDecisionTree.addRule(ruleCondition);

		return false;
	}

	public boolean violatesAnyRule(SignalSource querySignal) {

		return signalDecisionTree.violatesAnyRule(querySignal);
	}

}
