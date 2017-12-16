package com.ruleenginedemo.input.handler.impl;

import java.io.File;

import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.input.function.IOHelper;
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

		IOHelper.print("\n--Data stream started (Source : File)--" + file.getAbsolutePath());

		SignalSource[] signalSources = IOHelper.getSignalStreamFromFile(file);

		for (SignalSource ss : signalSources)
			if (ruleEngine.violatesAnyRule(ss))
				IOHelper.print(ss.toString());

		IOHelper.print("\n--Data stream Ended (Source : File)--");
	}

}
