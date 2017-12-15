package com.ruleenginedemo.main.control;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;
import com.ruleenginedemo.rule.model.data.StringHelper;

public class DataStreamApp {

	public static SignalRuleEngine signalRuleEngine;

	public static void main(String[] args) {

		signalRuleEngine = new SignalRuleEngine();

		signalRuleEngine.addRule("lt1 value should not be 2");
		signalRuleEngine.addRule("lt1 value should not be 3");
		signalRuleEngine.addRule("lt2 value must  be low");

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "2", "integer")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "3", "integer")));

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "4", "integer")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "high", "string")));
		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt1", "medium", "string")));

		System.out.println(signalRuleEngine.violatesAnyRule(new SignalSource("lt2", "low", "string")));

		System.out.println("Time check");

		signalRuleEngine.addRule("lt3 value must be future");
		signalRuleEngine.addRule("lt4 value must not be future");
		signalRuleEngine.addRule("lt5 value must not be in past");
		signalRuleEngine.addRule("lt6 value must be in past");
		signalRuleEngine.addRule("lt7 value must be in future");

		System.out.println(signalRuleEngine
				.violatesAnyRule(new SignalSource("lt3", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		System.out.println(signalRuleEngine
				.violatesAnyRule(new SignalSource("lt4", "2018-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		System.out.println(signalRuleEngine
				.violatesAnyRule(new SignalSource("lt5", "2016-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		System.out.println(signalRuleEngine
				.violatesAnyRule(new SignalSource("lt6", "2015-04-10 10:16:55", StringHelper.DATETIMETYPE)));
		System.out.println(signalRuleEngine
				.violatesAnyRule(new SignalSource("lt6", "2019-04-10 10:16:55", StringHelper.DATETIMETYPE)));

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
