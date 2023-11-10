package com.gmail.psyh2409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		String line = "";
		String message = "Enter a five letter word: ";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			while(true) {
				System.out.println(message);
				line = br.readLine();
				if (line.length() == 5)
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		isItPalindrom(line);
		replaceVowelsWithDash(line);
		countWords(message);
		countSameWords("Glory to Ukraine! Glory to the heroes! " 
				+ "Glory to the nation! Death to the enemies! "
				+ "Ukraine! Above all!");
		
	}

	public static void countWords(String message) {
		System.out.println("Sentens '" + message + "' has " + 
		message.split(" ").length + " words.");
	}

	private static void countSameWords(String string) {
		System.out.println(string);
		String[] strings = string.split("[^a-zA-Z]");
		String temp = "";
		int numTimes = 0;
		for (int i = 0; i < strings.length; i++) {
			numTimes = 0;
			temp = strings[i];
			for (int j = i; j < strings.length; j++) {				
				if (temp.equalsIgnoreCase(strings[j])){
					numTimes++;
					strings[j] = "";
				}
			}
			if(temp.equalsIgnoreCase("")) continue;
			System.out.println(temp.concat(" - " + numTimes));
		}
	}

	private static void replaceVowelsWithDash(String s) {
		char[] vowels = "aeyuioAEYUIO".toCharArray();
		char[] strng = s.toCharArray();
		for (int i = 0; i < vowels.length; i++) {
			for (int j = 0; j < strng.length; j++) {
				if (vowels[i] == strng[j])
					strng[j] = '-';
			}
		}
		System.out.println(strng);
	}

	private static void isItPalindrom(String s) {
		StringBuilder sb = new StringBuilder(s);
		boolean b = sb.reverse().toString().compareToIgnoreCase(s) == 0;
		System.out.println("Word " + s + " is " + 
					(b ? "" : "not") + " palindrom.");
	}

}
