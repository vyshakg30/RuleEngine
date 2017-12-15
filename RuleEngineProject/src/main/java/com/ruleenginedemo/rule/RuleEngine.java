package com.ruleenginedemo.rule;

import com.ruleenginedemo.input.data.SignalSource;

public interface RuleEngine {

	public boolean addRule(String ruleSentence);

	public boolean violatesAnyRule(SignalSource querySignal);

}
