package com.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * @author tians1
 *
 */
public class NewYearChaos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int m = 0; m < T; m++) {
			int n = sc.nextInt();
			int q[] = new int[n];
			for (int index = 0; index < n; index++) {
				q[index] = sc.nextInt();
			}
			minimumBribes(q);
		}
		sc.close();
	}

	static void minimumBribes(int[] q) {
		int bribe = 0;
		boolean chaotic = false;
		for (int i = 0; i < q.length; i++) {
			if (q[i] - (i + 1) > 2) {
				chaotic = true;
				break;
			}
			for (int j = Math.max(0, q[i] - 2); j < i; j++)
				if (q[j] > q[i])
					bribe++;
		}
		System.out.println(chaotic ? "Too chaotic" : bribe);
	}

}
