package com.ruleenginedemo.input.handler.impl;

import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.input.handler.InputHandler;
import com.ruleenginedemo.rule.RuleEngine;

public class RuleConsoleInputHandler extends InputHandler {
	String ruleSentence;

	public RuleConsoleInputHandler(RuleEngine ruleEngine) {
		super(ruleEngine);

	}

	@Override
	public void run() {

		IOHelper.print("Enter Rules To be applied on Data Stream : ");

		while (true) {

			IOHelper.print("New Rule ? : ");
			ruleSentence = IOHelper.getInput();

			if (ruleEngine.addRule(ruleSentence))
				IOHelper.print("Rule successfully added.");

		}

	}

}
