package com.ruleenginedemo.functionality;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ruleengine.input.data.SignalSource;

public class TestIntegerTypeValuesRule extends TestValueType {

	@Test
	public void testLowerLimitValues() {

		assertFalse(violatesAnyRule(new SignalSource("lt1", "15", "integer")));

		addRule("lt1 value should be less than 10");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "15", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt1", "5", "integer")));
		addRule("lt1 value should be less than 2");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "5", "integer")));

		addRule("lt5 value must be below than 0.5");
		assertTrue(violatesAnyRule(new SignalSource("lt5", "0.6", "integer")));

	}

	@Test
	public void testUpperLimitValue() {

		assertFalse(violatesAnyRule(new SignalSource("lt1", "5", "integer")));
		addRule("lt1 value should be above than 10");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "5", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt1", "20", "integer")));
		addRule("lt1 value should be higher than 25");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "20", "integer")));

		addRule("lt5 value must be beyound 0.5");
		assertFalse(violatesAnyRule(new SignalSource("lt5", "0.5", "integer")));

	}

	@Test
	public void testExclusiveValue() {

		addRule("lt1 value should be 1000");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "0", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt1", "1000", "integer")));

		assertFalse(violatesAnyRule(new SignalSource("lt3", "150", "integer")));
		addRule("lt3 value must be -7");
		assertTrue(violatesAnyRule(new SignalSource("lt3", "150", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt3", "-7", "integer")));

		addRule("lt2 value should always be -800");
		assertFalse(violatesAnyRule(new SignalSource("lt2", "-800", "integer")));
		assertTrue(violatesAnyRule(new SignalSource("lt2", "250.9", "integer")));

		addRule("lt4 value should always be 500");
		addRule("lt4 value must be -800");
		assertFalse(violatesAnyRule(new SignalSource("lt4", "500", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt4", "-800", "integer")));

	}

	@Test
	public void testForbiddenValue() {

		assertFalse(violatesAnyRule(new SignalSource("lt3", "-80.5", "integer")));
		addRule("lt3 value mustn't be -80.5");
		assertTrue(violatesAnyRule(new SignalSource("lt3", "-80.5", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt3", "150", "integer")));

		assertFalse(violatesAnyRule(new SignalSource("lt1", "700", "integer")));
		addRule("lt1 value shouldn't be 700");
		assertFalse(violatesAnyRule(new SignalSource("lt1", "-94.4", "integer")));
		assertTrue(violatesAnyRule(new SignalSource("lt1", "700", "integer")));

		addRule("lt4 value should never be 8051.5");
		addRule("lt4 value must not be -40.5");
		assertTrue(violatesAnyRule(new SignalSource("lt4", "8051.5", "integer")));
		assertTrue(violatesAnyRule(new SignalSource("lt4", "-40.5", "integer")));

	}

	@Test
	public void testMultipleValue() {

		assertFalse(violatesAnyRule(new SignalSource("lt1", "5", "integer")));
		addRule("lt1 value should be above than 10");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "5", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt1", "20", "integer")));
		addRule("lt1 value should be higher than 25");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "20", "integer")));

		assertFalse(violatesAnyRule(new SignalSource("lt2", "700", "integer")));
		addRule("lt2 value shouldn't be 700");
		assertFalse(violatesAnyRule(new SignalSource("lt2", "-94.4", "integer")));
		assertTrue(violatesAnyRule(new SignalSource("lt2", "700", "integer")));

		addRule("lt5 value must be below than 0.5");
		assertTrue(violatesAnyRule(new SignalSource("lt5", "0.6", "integer")));

		addRule("lt4 value should always be 500");
		addRule("lt4 value must be -800");
		assertFalse(violatesAnyRule(new SignalSource("lt4", "500", "integer")));
		assertFalse(violatesAnyRule(new SignalSource("lt4", "-800", "integer")));

	}

}
