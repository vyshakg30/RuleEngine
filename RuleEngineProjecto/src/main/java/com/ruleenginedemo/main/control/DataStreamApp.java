package com.ruleenginedemo.main.control;

import java.io.File;
import java.util.Scanner;

import com.ruleenginedemo.input.data.IOHelper;
import com.ruleenginedemo.input.handler.impl.DataStreamFileInputHandler;
import com.ruleenginedemo.input.handler.impl.RuleQueryConsoleInputHandler;
import com.ruleenginedemo.rule.RuleEngine;
import com.ruleenginedemo.rule.impl.SignalRuleEngine;

public class DataStreamApp {

	public static RuleEngine ruleEngine;

	public static void main(String[] args) {

		createRuleEngine();
		startDataStreamFileInputHandler();
		startRuleQueryStreamInputHandler();

	}

	private static void createRuleEngine() {
		ruleEngine = new SignalRuleEngine();

	}

	private static void startRuleQueryStreamInputHandler() {

		new RuleQueryConsoleInputHandler(ruleEngine).start();

	}

	private static void startDataStreamFileInputHandler() {

		File file = IOHelper.getDataStreamFile();
		new DataStreamFileInputHandler(ruleEngine, file).start();

	}

}
