package com.ruleenginedemo.rule.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.model.data.RuleCondition;
import com.ruleenginedemo.rule.persistence.handle.Persister;
import com.ruleenginedemo.rule.persistence.handle.impl.FilePersister;

public class SignalRuleEngine implements RuleEngine {

	SignalDecisionTree signalDecisionTree;
	SentenceParseGraph sentenceParseGraph;
	Set<RuleCondition> ruleConditions;
	Persister filepersist;

	public SignalRuleEngine(boolean loadOldRuleConditionsFromFile) {

		signalDecisionTree = new SignalDecisionTree();
		sentenceParseGraph = new SentenceParseGraph();
		ruleConditions = new HashSet<>();
		filepersist = new FilePersister();

		if (loadOldRuleConditionsFromFile)
			loadRuleConditionsFromFile();

	}

	@Override
	public boolean addRule(String ruleSentence) {

		RuleCondition ruleCondition;
		boolean isRuleAddedToDecisionTree = false;

		ruleCondition = sentenceParseGraph.getRuleCondition(ruleSentence);

		if (ruleCondition != null) {
			isRuleAddedToDecisionTree = signalDecisionTree.addRule(ruleCondition);

			if (isRuleAddedToDecisionTree) {
				ruleConditions.add(ruleCondition);
				filepersist.persistRule(ruleConditions);
			}
		}

		return isRuleAddedToDecisionTree;
	}

	@Override
	public boolean violatesAnyRule(SignalSource querySignal) {
		return signalDecisionTree.violatesAnyRule(querySignal);
	}

	private void loadRuleConditionsFromFile() {

		List<RuleCondition> ruleConditionsFromFile = IOHelper.getRuleConditionsFromFile();

		for (RuleCondition condition : ruleConditionsFromFile)
			if (signalDecisionTree.addRule(condition))
				this.ruleConditions.add(condition);

	}

}
