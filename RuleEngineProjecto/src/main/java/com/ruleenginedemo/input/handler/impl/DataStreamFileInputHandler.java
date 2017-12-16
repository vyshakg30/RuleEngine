package com.ruleenginedemo.input.handler.impl;

import java.io.File;

import com.ruleenginedemo.input.handler.InputHandler;
import com.ruleenginedemo.rule.RuleEngine;

public class DataStreamFileInputHandler extends InputHandler {

	File file;

	public DataStreamFileInputHandler(RuleEngine ruleEngine) {
		super(ruleEngine);

	}

	public DataStreamFileInputHandler(RuleEngine ruleEngine, File file) {
		super(ruleEngine);
		this.file = file;
	}

	@Override
	public void run() {
		System.out.println("DataStreamFileInputHandler");
	}

}
