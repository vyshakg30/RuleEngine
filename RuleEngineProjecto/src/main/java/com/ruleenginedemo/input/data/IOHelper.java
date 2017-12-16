package com.ruleenginedemo.input.data;

import java.io.File;
import java.util.Scanner;

public class IOHelper {
	public static final String SPLITLITERALS = " ";
	public static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}

	public static void print(String string) {
		System.out.println(string);

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
			filePath = System.getProperty("user.dir") + "/" + getInput();
			file = new File(filePath);
		} while (!file.exists());

		return file;

	}

}
