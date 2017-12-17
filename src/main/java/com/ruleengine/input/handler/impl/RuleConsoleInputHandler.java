package com.ruleengine.input.handler.impl;

import com.ruleengine.input.function.IOHelper;
import com.ruleengine.input.handler.InputHandler;
import com.ruleengine.rule.RuleEngine;

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
