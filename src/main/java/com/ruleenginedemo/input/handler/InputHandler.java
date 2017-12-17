package com.ruleenginedemo.input.handler;

import com.ruleenginedemo.rule.RuleEngine;

public abstract class InputHandler extends Thread {

	public static RuleEngine ruleEngine;

	public InputHandler(RuleEngine ruleEngine) {
		super();
		InputHandler.ruleEngine = ruleEngine;
	}

}
