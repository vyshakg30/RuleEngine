package com.ruleenginedemo.functionality;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.model.data.StringHelper;

public class TestDateTypeValuesRule extends TestValueType {

	@Test
	public void testExclusiveValue() {

		// same set
		assertFalse(violatesAnyRule(new SignalSource("atl3", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		addRule("atl3 value must future");
		assertTrue(violatesAnyRule(new SignalSource("atl3", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));

		// same set
		assertFalse(violatesAnyRule(new SignalSource("atl5", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		addRule("atl5 value must be in past");
		assertTrue(violatesAnyRule(new SignalSource("atl5", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));

		// mixed set
		addRule("atl6 value should be in past");
		addRule("atl7 value must be in future");

		assertFalse(violatesAnyRule(new SignalSource("atl7", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertTrue(violatesAnyRule(new SignalSource("atl6", "2019-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(violatesAnyRule(new SignalSource("atl6", "2011-03-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertTrue(violatesAnyRule(new SignalSource("atl7", "2017-01-01 10:16:55", StringHelper.DATETIMETYPE)));

	}

	@Test
	public void testForbiddenValue() {

		// same set
		assertFalse(violatesAnyRule(new SignalSource("atl3", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		addRule("atl3 value must not be future");
		assertTrue(violatesAnyRule(new SignalSource("atl3", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));

		// same set
		assertFalse(violatesAnyRule(new SignalSource("atl5", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		addRule("atl5 value mustn't be in past");
		assertTrue(violatesAnyRule(new SignalSource("atl5", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));

		// mixed set
		addRule("atl6 value should never be in past");
		addRule("atl7 value shouldn't be in future");

		assertTrue(violatesAnyRule(new SignalSource("atl7", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertTrue(violatesAnyRule(new SignalSource("atl6", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertTrue(violatesAnyRule(new SignalSource("atl6", "2011-03-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(violatesAnyRule(new SignalSource("atl7", "2017-01-01 10:16:55", StringHelper.DATETIMETYPE)));

	}

	@Test
	public void testMultipleValues() {

		// mixed set
		addRule("atl3 value must be future");
		assertFalse(violatesAnyRule(new SignalSource("atl3", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(violatesAnyRule(new SignalSource("atl4", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));

		addRule("atl4 value must not be future");
		assertTrue(violatesAnyRule(new SignalSource("atl4", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));

		addRule("atl5 value must not be in past");
		addRule("atl6 value must be in past");
		addRule("atl7 value must not be in past");

		assertTrue(violatesAnyRule(new SignalSource("atl5", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(violatesAnyRule(new SignalSource("atl6", "2015-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		assertFalse(violatesAnyRule(new SignalSource("atl9", "2019-04-10 10:16:55", StringHelper.DATETIMETYPE)));

	}

}
