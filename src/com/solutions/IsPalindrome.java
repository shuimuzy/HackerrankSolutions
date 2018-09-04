package com.solutions;

import java.util.Scanner;

public class IsPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(checkPalindrome(n) ? "Yes" : "No");
		
	}

	private static boolean checkPalindrome(int n) {
		String str = Integer.toString(n);
		String reversed = new StringBuffer(str).reverse().toString();
		return str.equals(reversed);
	}

}
