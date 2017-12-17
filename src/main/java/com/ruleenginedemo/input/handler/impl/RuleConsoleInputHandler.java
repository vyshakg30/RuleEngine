package com.ruleenginedemo.input.handler.impl;

import com.ruleenginedemo.input.function.IOHelper;
import com.ruleenginedemo.input.handler.InputHandler;
import com.ruleenginedemo.rule.RuleEngine;

public class RuleConsoleInputHandler extends InputHandler {

	public RuleConsoleInputHandler(RuleEngine ruleEngine) {
		super(ruleEngine);

	}

	@Override
	public void run() {

		prerun();
		String ruleSentence;
		while (true) {

			ruleSentence = IOHelper.getStringInput();
			if (ruleEngine.addRule(ruleSentence))
				IOHelper.print("Rule [" + ruleSentence + "]  successfully added and persisted.");
			IOHelper.print("New Rule ? : ");

		}

	}

	private void prerun() {
		IOHelper.print("Enter Rules To be applied on Data Stream : ");

	}

}
