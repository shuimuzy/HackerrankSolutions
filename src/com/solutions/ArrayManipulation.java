package com.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * @param args
 */
public class ArrayManipulation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		long[] offsets = new long[n + 1];
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            offsets[a - 1] += k;
            offsets[b] -= k;
        }
        
        long max = offsets[0];
        for (int i = 1; i < n; ++i) {
            offsets[i] += offsets[i - 1];
            max = Math.max(offsets[i], max);
        }

		System.out.println(max);
		in.close();
	}
}
