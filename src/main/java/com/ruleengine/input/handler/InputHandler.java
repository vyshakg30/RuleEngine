package com.ruleengine.input.handler;

import com.ruleengine.rule.RuleEngine;

public abstract class InputHandler extends Thread {

	public static RuleEngine ruleEngine;

	public InputHandler(RuleEngine ruleEngine) {
		super();
		InputHandler.ruleEngine = ruleEngine;
	}

}
