package com.ruleengine.rule;

import com.ruleengine.input.data.SignalSource;

public interface RuleEngine {

	public boolean addRule(String ruleSentence);

	public boolean violatesAnyRule(SignalSource querySignal);

}
