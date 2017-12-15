package com.ruleenginedemo.functionality;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;

public class TestIntegerTypeValueRule {

	RuleEngine signalRuleEngine;

	@Before
	public void setUp() throws Exception {
		signalRuleEngine = new SignalRuleEngine();

	}

	@Test
	public void testLowerLimitValues() {

		signalRuleEngine.addRule("");
		signalRuleEngine.addRule("");
		signalRuleEngine.addRule("");

		assertTrue(true);
	}

	@Test
	public void testLowerLimitMultipleValue() {

		assertTrue(true);

	}

	@Test
	public void testUpperLimitValue() {

		assertTrue(true);
	}

	@Test
	public void testUpperLimitMultipleValue() {

		assertTrue(true);
	}

	@Test
	public void testExclusiveValue() {

		assertTrue(true);
	}

	@Test
	public void testForbiddenValue() {

		assertTrue(true);
	}

}
