package com.ruleenginedemo.main.control;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.gson.Gson;
import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.input.handler.impl.DataStreamFileInputHandler;
import com.ruleenginedemo.input.handler.impl.RuleConsoleInputHandler;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;
import com.ruleenginedemo.rule.model.data.ConditionType;
import com.ruleenginedemo.rule.model.data.RuleCondition;

public class Test {

	public static RuleEngine ruleEngine;

	public static void main(String[] args) {

		Gson gson = new Gson();

		RuleCondition ruleCondition = new RuleCondition();
		ruleCondition.setSourceID("sass");
		ruleCondition.setDataType(ConditionType.INTEGER);
		ruleCondition.setLimitType(ConditionType.LOWERLIMIT);
		ruleCondition.setIntegerValue(32d);

		RuleCondition ruleCondition2 = new RuleCondition();
		ruleCondition2.setSourceID("sass");
		ruleCondition2.setDataType(ConditionType.INTEGER);
		ruleCondition2.setLimitType(ConditionType.LOWERLIMIT);
		ruleCondition2.setIntegerValue(32d);

		Set<RuleCondition> ruleConditions = new HashSet<RuleCondition>();

		System.out.println(gson.toJson(ruleCondition));

		RuleCondition ruleConditionBack = gson.fromJson(gson.toJson(ruleCondition), RuleCondition.class);

		IOHelper.print(ruleConditionBack.toString());

		ruleConditions.add(ruleCondition);
		ruleConditions.add(ruleCondition2);
		ruleConditions.add(ruleConditionBack);

		System.out.println(ruleConditions.contains(ruleCondition2));

		IOHelper.print(ruleConditions.size());

		System.out.println(ruleCondition.hashCode());
		System.out.println(ruleCondition2.hashCode());
		System.out.println(ruleConditionBack.hashCode());

		for (RuleCondition non : ruleConditions) {
			System.out.println("------------------");
			System.out.println(non);

		}

	}

	public static void main1(String[] args) {

		createRuleEngine();
		startDataStreamFileInputHandler();
		startRuleStreamInputHandler();

	}

	private static void createRuleEngine() {
		ruleEngine = new SignalRuleEngine();

	}

	private static void startRuleStreamInputHandler() {

		new RuleConsoleInputHandler(ruleEngine).start();

	}

	private static void startDataStreamFileInputHandler() {

		File file = IOHelper.getDataStreamFile();
		new DataStreamFileInputHandler(ruleEngine, file).start();

	}

}
