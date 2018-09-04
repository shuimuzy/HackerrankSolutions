package com.solutions;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		System.out.println(camelcase(s));

	}

	static int camelcase(String s) {
		int sum = 1;
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (Character.isUpperCase(ch)) {
				sum++;
			}
		}
		return sum;
	}

}
