package com.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 * @author TianS1
 *
 */
public class HackerrankInString {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		while(num-- > 0) {
			String str = scan.next();
			boolean bool = hackerrankInString(str);
			System.out.println(bool ? "YES" : "NO");
		}
		scan.close();
		
	}

	private static boolean hackerrankInString(String str) {
		String hacker = "hackerrank";
		
		if (str.length() < hacker.length()) {
			return false;
		}
		int index=0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == hacker.charAt(index)) {
				index++;
			}
			if (index == hacker.length()) {
				return true;
			}
		}
		return false;
	}
}
