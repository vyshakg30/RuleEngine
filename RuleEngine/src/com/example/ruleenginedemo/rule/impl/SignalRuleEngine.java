package com.example.ruleenginedemo.rule.impl;

import com.example.ruleenginedemo.data.RuleCondition;
import com.example.ruleenginedemo.input.data.SignalSource;
import com.example.ruleenginedemo.rule.RuleEngine;

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
