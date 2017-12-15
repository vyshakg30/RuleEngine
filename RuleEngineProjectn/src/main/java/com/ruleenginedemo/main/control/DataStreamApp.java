package com.ruleenginedemo.main.control;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;

public class DataStreamApp {

	public static SignalRuleEngine signalRuleEngine;

	public static void main(String[] args) {

		signalRuleEngine = new SignalRuleEngine();

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "2", "integer")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "3", "integer")));

	}

	public static void main1(String[] args) {

		signalRuleEngine = new SignalRuleEngine();

		signalRuleEngine.addRule("lt1 value should only be high");
		signalRuleEngine.addRule("lt1 value should only be medium");
		signalRuleEngine.addRule("lt2 value must  be low");

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "2", "integer")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "3", "integer")));

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "4", "integer")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt2", "low", "string")));

		System.out.println("Time check");

	}

}
