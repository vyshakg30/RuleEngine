package com.ruleenginedemo.input.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ruleenginedemo.input.data.SignalSource;
import com.ruleenginedemo.rule.model.data.RuleCondition;

public class IOHelper {
	public static final String RULESFILE = "rules.json";
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

	public static String getStringInput() {
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
			print("Enter Data stream file name available in current Directory to read signals from.");
			filePath = getCurrentDirectoryPath() + "/" + getStringInput();
			file = new File(filePath);
		} while (!file.exists());

		return file;

	}

	public static String getCurrentDirectoryPath() {
		return System.getProperty("user.dir");
	}

	public static String getRulesFilePath() {
		File file = new File(getCurrentDirectoryPath() + "/" + RULESFILE);
		try {
			file.createNewFile();
			return file.getAbsolutePath();
		} catch (Exception e) {

		}
		return null;
	}

	public static List<SignalSource> getSignalStreamFromFile(File file) {

		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			SignalSource[] signalSources = gson.fromJson(br, SignalSource[].class);
			br.close();
			return Arrays.asList(signalSources);
		} catch (Exception e) {
		}
		return new ArrayList<SignalSource>();
	}

	public static List<RuleCondition> getRuleConditionsFromFile() {

		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(getRulesFilePath()));
			RuleCondition[] ruleConditions = gson.fromJson(br, RuleCondition[].class);
			br.close();
			return Arrays.asList(ruleConditions);
		} catch (Exception e) {
		}
		return new ArrayList<RuleCondition>();
	}

	public static boolean writeRuleConditionsToFile(Set<RuleCondition> ruleconditions) {
		try {
			Writer writer = new FileWriter(getRulesFilePath());
			Gson gson = new GsonBuilder().create();
			gson.toJson(ruleconditions, writer);
			writer.flush();
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	public static int getIntegerInput() {
		try {
			sc = new Scanner(System.in);
			return sc.nextInt();
		} catch (Exception e) {
		}
		return 0;
	}

	public static void removeRulesFile() {

		File file = new File(getCurrentDirectoryPath() + "/" + RULESFILE);
		try {
			file.delete();
		} catch (Exception e) {

		}

	}

}
