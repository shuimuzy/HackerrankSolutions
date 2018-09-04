package com.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strong-password/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * 
 * @author TianS1
 *
 */
public class StrongPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String password = sc.next();
		sc.close();
		
		int answer = minimumNumber(n, password);

		System.out.println(answer);
	}

	static int minimumNumber(int n, String password) {
		
		String numbers = "0123456789";
		String lower_case = "abcdefghijklmnopqrstuvwxyz";
		String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String special_characters = "!@#$%^&*()-+";
		boolean containNumbers = false;
		boolean containLowerCase = false;
		boolean containUpperCase = false;
		boolean containSpecialChar = false;

		for (int i = 0; i < password.length(); i++) {
			String ch = String.valueOf(password.charAt(i));
			if (numbers.contains(ch)) {
				containNumbers = true;
			}
			if (lower_case.contains(ch)) {
				containLowerCase = true;
			}
			if (upper_case.contains(ch)) {
				containUpperCase = true;
			}
			if (special_characters.contains(ch)) {
				containSpecialChar = true;
			}
		}
		int sum=0;
		if (!containNumbers) sum++;
		if (!containLowerCase) sum++;
		if (!containUpperCase) sum++;
		if (!containSpecialChar) sum++;
		
		if (n + sum < 6) {
			sum += 6 - (n+sum);
		}
		
		return sum;
    }
}
