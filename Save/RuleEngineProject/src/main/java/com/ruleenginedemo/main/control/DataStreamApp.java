package com.ruleenginedemo.main.control;

import java.io.File;

import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.input.handler.impl.DataStreamFileInputHandler;
import com.ruleenginedemo.input.handler.impl.RuleConsoleInputHandler;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;

public class DataStreamApp {

	public static RuleEngine ruleEngine;

	public static void main(String[] args) {

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
