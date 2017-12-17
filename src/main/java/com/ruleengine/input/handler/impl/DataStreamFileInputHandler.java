package com.ruleengine.input.handler.impl;

import java.io.File;
import java.util.List;

import com.ruleengine.input.data.SignalSource;
import com.ruleengine.input.function.IOHelper;
import com.ruleengine.input.handler.InputHandler;
import com.ruleengine.rule.RuleEngine;

public class DataStreamFileInputHandler extends InputHandler {

	File file;
	int dataStreamProcessDelay = 60;

	public DataStreamFileInputHandler(RuleEngine ruleEngine) {
		super(ruleEngine);
	}

	public DataStreamFileInputHandler(RuleEngine ruleEngine, File file, int dataStreamProcessDelay) {
		super(ruleEngine);
		this.file = file;
		this.dataStreamProcessDelay = dataStreamProcessDelay;
	}

	public DataStreamFileInputHandler(RuleEngine ruleEngine, File file) {
		super(ruleEngine);
		this.file = file;

	}

	@Override
	public void run() {

		while (true) {

			List<SignalSource> signals = IOHelper.getSignalStreamFromFile(file);
			preDataStream();
			for (SignalSource signal : signals)
				if (ruleEngine.violatesAnyRule(signal))
					IOHelper.print(signal);
			postDataStream();
		}

	}

	private void postDataStream() {
		IOHelper.print("\nEnd of stream reached.Now a " + dataStreamProcessDelay
				+ " second delay defore re-reading from the same file.\n\nNew Rule ? :");
		try {
			sleep(dataStreamProcessDelay * 1000);
		} catch (InterruptedException e) {

		}

	}

	private void preDataStream() {
		IOHelper.print("\n--Stream Started--\nFollowing signals violated an existing rule.\n");

	}

}
