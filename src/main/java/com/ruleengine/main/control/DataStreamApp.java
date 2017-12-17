package com.ruleengine.main.control;

import java.io.File;

import com.ruleengine.input.function.IOHelper;
import com.ruleengine.input.handler.impl.DataStreamFileInputHandler;
import com.ruleengine.input.handler.impl.RuleConsoleInputHandler;
import com.ruleengine.rule.RuleEngine;
import com.ruleengine.rule.impl.SignalRuleEngine;

public class DataStreamApp {

	public static RuleEngine ruleEngine;

	public static void main(String[] args) {

		createRuleEngine();
		startDataStreamFileInputHandler();
		startRuleStreamInputHandler();

	}

	private static void createRuleEngine() {

		// loading rule conditions from persisted previously
		ruleEngine = new SignalRuleEngine(true);

	}

	private static void startDataStreamFileInputHandler() {

		File file = IOHelper.getDataStreamFile();
		new DataStreamFileInputHandler(ruleEngine, file).start();

	}

	private static void startRuleStreamInputHandler() {

		new RuleConsoleInputHandler(ruleEngine).start();

	}

}
