package com.ruleenginedemo.functionality;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ruleengine.input.data.SignalSource;

public class TestStringTypeValueRules extends TestValueType {

	@Test
	public void testExclusiveValue() {

		addRule("lt1 value should be high");
		assertTrue(violatesAnyRule(new SignalSource("lt1", "low", "string")));
		assertFalse(violatesAnyRule(new SignalSource("lt1", "high", "string")));

		assertFalse(violatesAnyRule(new SignalSource("lt3", "high", "string")));
		addRule("lt3 value must be low");
		assertTrue(violatesAnyRule(new SignalSource("lt3", "high", "string")));
		assertFalse(violatesAnyRule(new SignalSource("lt3", "low", "string")));

		addRule("lt2 value should always be verylow");
		assertFalse(violatesAnyRule(new SignalSource("lt2", "verylow", "string")));
		assertTrue(violatesAnyRule(new SignalSource("lt2", "medium", "string")));

		addRule("lt4 value should always be veryhigh");
		addRule("lt4 value must be verylow");
		assertFalse(violatesAnyRule(new SignalSource("lt4", "veryhigh", "string")));
		assertFalse(violatesAnyRule(new SignalSource("lt4", "verylow", "string")));

	}

	@Test
	public void testForbiddenValue() {

		assertFalse(violatesAnyRule(new SignalSource("lt3", "low", "string")));
		addRule("lt3 value mustn't be low");
		assertTrue(violatesAnyRule(new SignalSource("lt3", "low", "string")));
		assertFalse(violatesAnyRule(new SignalSource("lt3", "high", "string")));

		assertFalse(violatesAnyRule(new SignalSource("lt1", "high", "string")));
		addRule("lt1 value shouldn't be high");
		assertFalse(violatesAnyRule(new SignalSource("lt1", "low", "string")));
		assertTrue(violatesAnyRule(new SignalSource("lt1", "high", "string")));

		addRule("lt4 value should never always be veryhigh");
		addRule("lt4 value must not be verylow");
		assertTrue(violatesAnyRule(new SignalSource("lt4", "veryhigh", "string")));
		assertTrue(violatesAnyRule(new SignalSource("lt4", "verylow", "string")));

	}

	@Test
	public void testMultipleValue() {

		addRule("lt1 value should only be high");
		addRule("lt2 value shouldn't be high");
		addRule("lt3 value should ");

		assertFalse(violatesAnyRule(new SignalSource("lt1", "high", "string")));
		assertTrue(violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		assertTrue(violatesAnyRule(new SignalSource("lt2", "high", "string")));
		assertFalse(violatesAnyRule(new SignalSource("lt3", "medium", "string")));

		addRule("lt1 value should be medium");
		assertFalse(violatesAnyRule(new SignalSource("lt1", "medium", "string")));

	}
}
