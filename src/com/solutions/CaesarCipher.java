package com.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 * @author TianS1
 *
 */

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		String str = scan.next();
		int k = scan.nextInt();
		scan.close();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char ch = str.charAt(i);
			sb.append(encrypt(ch, k));
		}

		System.out.println(sb);

	}

	private static char encrypt(char ch, int K) {
		if (!Character.isLetter(ch)) {
			return ch;
		}
		char base = Character.isLowerCase(ch) ? 'a' : 'A';
		return (char) ((ch - base + K) % 26 + base);
	}

}
