package com.solutions;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/weighted-uniform-string/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * 
 * @author tians1
 *
 */
public class WeightedUniformStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int queriesCount = scanner.nextInt();

		HashSet<Integer> weights = new HashSet<>();
		weights = gainWeights(s, weights);

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = scanner.nextInt();
			System.out.println(weights.contains(queriesItem) ? "YES" : "NO");
		}
		scanner.close();
	}

	private static HashSet<Integer> gainWeights(String s, HashSet<Integer> weights) {

		int weight = s.charAt(0) - 'a' + 1; // 1st letter's weight
		weights.add(weight);

		for (int i = 1; i < s.length(); i++) {
			char ch1 = s.charAt(i - 1);
			char ch2 = s.charAt(i);
			if (ch1 != ch2) {
				weight = 0;
			}
			weight += ch2 - 'a' + 1;
			weights.add(weight);
		}
		return weights;
	}

}
