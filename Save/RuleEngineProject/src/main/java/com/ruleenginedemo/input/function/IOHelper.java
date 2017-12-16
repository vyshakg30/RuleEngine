package com.ruleenginedemo.input.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.model.data.RuleCondition;

public class IOHelper {
	public static final String RULESFILE = "rules.text";
	public static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}

	public static void print(Object o) {
		System.out.println(o);

	}

	public static File getFile(String string) {
		System.out.println(string);
		return null;
	}

	public static String getInput() {
		try {
			String input = sc.nextLine();
			return input.trim().toLowerCase();
		} catch (Exception e) {
			return "";
		}

	}

	public static File getDataStreamFile() {

		String filePath;
		File file;

		do {
			print("Enter Data stream file in Current Directory");
			filePath = getCurrentDirectory() + "/" + getInput();
			file = new File(filePath);
		} while (!file.exists());

		return file;

	}

	public static String getCurrentDirectory() {
		return System.getProperty("user.dir");
	}

	public static String getRulesFile() {
		File file = new File(getCurrentDirectory() + "/" + RULESFILE);
		try {
			file.createNewFile();
			return file.getAbsolutePath();
		} catch (Exception e) {

		}
		return null;
	}

	public static SignalSource[] getSignalStreamFromFile(File file) {

		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			return gson.fromJson(br, SignalSource[].class);
		} catch (Exception e) {
		}
		return null;
	}

	public static RuleCondition[] getRuleConditionsFromFile() {

		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(getRulesFile()));
			return gson.fromJson(br, RuleCondition[].class);
		} catch (Exception e) {
		}
		return null;
	}

	/*
	 * public static WriteRuleConditionsToFile() {
	 * 
	 * }
	 */
	
}
