package com.ruleenginedemo.functionality;

import org.junit.After;
import org.junit.Before;

import com.ruleengine.input.data.SignalSource;
import com.ruleengine.input.function.IOHelper;
import com.ruleengine.rule.RuleEngine;
import com.ruleengine.rule.impl.SignalRuleEngine;

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
