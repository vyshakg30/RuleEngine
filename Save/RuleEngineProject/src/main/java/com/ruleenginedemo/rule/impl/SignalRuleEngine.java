package com.ruleenginedemo.rule.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.model.data.RuleCondition;

public class SignalRuleEngine implements RuleEngine {

	SignalDecisionTree signalDecisionTree;
	SentenceParseGraph sentenceParseGraph;
	Set<RuleCondition> ruleConditions;

	public SignalRuleEngine() {

		signalDecisionTree = new SignalDecisionTree();
		sentenceParseGraph = new SentenceParseGraph();
		ruleConditions = new HashSet<>();
		loadRuleConditionsFromFile();

	}

	@Override
	public boolean addRule(String ruleSentence) {

		RuleCondition ruleCondition;
		boolean isRuleAdded = false;

		ruleCondition = sentenceParseGraph.getRuleCondition(ruleSentence);

		if (ruleCondition != null)
			isRuleAdded = signalDecisionTree.addRule(ruleCondition);

		if (isRuleAdded)
			persistRule(ruleCondition);

		return isRuleAdded;
	}

	@Override
	public boolean violatesAnyRule(SignalSource querySignal) {
		return signalDecisionTree.violatesAnyRule(querySignal);
	}

	private void loadRuleConditionsFromFile() {

		RuleCondition conditions[] = IOHelper.getRuleConditionsFromFile();
		if (conditions != null) {
			ruleConditions = ((HashSet<RuleCondition>) Arrays.asList(conditions));

		}

	}

	private void persistRule(RuleCondition ruleCondition) {

		ruleConditions.add(ruleCondition);
		writeRuleConditionsToFile();
	}

	private void writeRuleConditionsToFile() {

	}

}
