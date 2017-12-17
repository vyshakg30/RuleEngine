package com.ruleenginedemo.functionality;

import org.junit.After;
import org.junit.Before;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;

public class TestValueType {

	RuleEngine ruleEngine;

	@Before
	public void setUp() throws Exception {
		ruleEngine = new SignalRuleEngine(false);

	}
	
	@After
	public void tearDown() throws Exception {
		IOHelper.removeRulesFile();

	}

	boolean violatesAnyRule(SignalSource signalSource) {

		return ruleEngine.violatesAnyRule(signalSource);
	}

	void addRule(String string) {
		ruleEngine.addRule(string);

	}

}
