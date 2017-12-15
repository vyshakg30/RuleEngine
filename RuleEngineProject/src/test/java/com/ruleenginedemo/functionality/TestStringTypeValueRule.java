package com.ruleenginedemo.functionality;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;

public class TestStringTypeValueRule {

	RuleEngine signalRuleEngine;

	@Before
	public void setUp() throws Exception {
		signalRuleEngine = new SignalRuleEngine();
	}

	@Test
	public void testExclusiveValue() {

		assertTrue(true);
	}

	@Test
	public void testForbiddenValue() {

		signalRuleEngine.addRule("lt2 value shouldn't be high");
		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		assertTrue(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		signalRuleEngine.addRule("lt3 value mustn't be low");
		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		assertTrue(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		signalRuleEngine.addRule("lt2 value shouldn not be verylow");
		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		assertTrue(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		signalRuleEngine.addRule("lt2 value should never be veryhigh");
		signalRuleEngine.addRule("lt2 value mustn't be veryhigh");
		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		assertTrue(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

	}

	@Test
	public void testMultipleValue() {

		signalRuleEngine.addRule("lt1 value should only be high");
		signalRuleEngine.addRule("lt2 value shouldn't be high");
		signalRuleEngine.addRule("lt3 value should ");

		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		assertTrue(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		assertTrue(signalRuleEngine.violatesAnyRule(new SignalSource("lt2", "high", "string")));
		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt3", "medium", "string")));

		signalRuleEngine.addRule("lt1 value should be medium");
		assertFalse(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

	}
}
