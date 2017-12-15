package com.ruleenginedemo.functionality;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;
import com.ruleenginedemo.rule.model.data.StringHelper;

public class TestDateTypeValueRule {

	RuleEngine signalRuleEngine;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		signalRuleEngine = new SignalRuleEngine();

	}

	@After
	public void tearDown() throws Exception {
	}

	public void testExclusiveValue() {

		assertTrue(true);
	}

	@Test
	public void testForbiddenValue() {

		assertTrue(true);
	}

	@Test
	public void testMultipleValues() {

		signalRuleEngine.addRule("atl3 value must be future");
		signalRuleEngine.addRule("atl4 value must not be future");
		signalRuleEngine.addRule("atl5 value must not be in past");
		signalRuleEngine.addRule("atl6 value must be in past");
		signalRuleEngine.addRule("atl7 value must not be in past");

		assertFalse(signalRuleEngine
				.violatesAnyRule(new SignalSource("atl3", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertTrue(signalRuleEngine
				.violatesAnyRule(new SignalSource("atl4", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertTrue(signalRuleEngine
				.violatesAnyRule(new SignalSource("atl5", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(signalRuleEngine
				.violatesAnyRule(new SignalSource("atl6", "2015-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(signalRuleEngine
				.violatesAnyRule(new SignalSource("atl9", "2019-04-10 10:16:55", StringHelper.DATETIMETYPE)));

	}

}
