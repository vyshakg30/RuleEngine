package com.example.ruleenginedemo.rule.impl;

import com.example.ruleenginedemo.data.RuleCondition;
import com.example.ruleenginedemo.data.Signal;
import com.example.ruleenginedemo.data.StringHelper;
import com.example.ruleenginedemo.rule.DecisionTree;
import com.example.ruleenginedemo.rule.RuleEngine;

public class SignalRuleEngine implements RuleEngine {

	SignalDecisionTree signalDecisionTree;
	SentenceParseGraph sentenceParseGraph;

	public SignalRuleEngine() {
		signalDecisionTree = new SignalDecisionTree();
		sentenceParseGraph = new SentenceParseGraph();
	}

	public DecisionTree getSignalTree() {
		return signalDecisionTree;
	}

	public void setSignalTree(SignalDecisionTree signalTree) {
		this.signalDecisionTree = signalTree;
	}

	public boolean matchesRule(String streamData) {

		return false;
	}

	public boolean addRule(String ruleSentence) {

		RuleCondition ruleCondition;
		ruleCondition = sentenceParseGraph.getRuleCondition(ruleSentence);
		if (ruleCondition != null)
			return signalDecisionTree.addRule(ruleCondition);

		return false;
	}

	private Signal getSignalFromDecisionTree(String[] ruleTokens) {

		Signal signal = null;
		String sourceID = ruleTokens[0];

		if (StringHelper.isAlphaNumeric(sourceID)) {

			// signal = signalDecisionTree.getSignal(sourceID);
			if (signal == null) {
				// Create New signal
				signal = new Signal(sourceID);
				// signalDecisionTree.addSignal(signal);
			}

		}
		return signal;
	}

}
