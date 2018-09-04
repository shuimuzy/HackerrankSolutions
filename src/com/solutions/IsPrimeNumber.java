package com.solutions;

import java.util.Scanner;

public class IsPrimeNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(isPrime(n) ? "Yes" : "No");
	}

	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else if (n == 2) { // account for even numbers now, so that we can do i+=2 in loop below
			return true;     //2 is a prime number
		} else if (n % 2 == 0) { // account for even numbers now, so that we can do i+=2 in loop below
			return false;
		}
		int sqrt = (int) Math.sqrt(n); //square root
		for (int i = 3; i <= sqrt; i += 2) { // skips even numbers for faster results
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
