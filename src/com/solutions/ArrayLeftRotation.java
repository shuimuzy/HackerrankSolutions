package com.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays&h_r=next-challenge&h_v=zen
 * @author tians1
 *
 */
public class ArrayLeftRotation {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		scanner.nextLine();
		String[] aItems = scanner.nextLine().split(" ");
		scanner.close();
		String[] resultArr = new String[n];
        for (int i = 0; i < n; i++) {
            int index = (i - d + n) % n;
            resultArr[index] = aItems[i];
        }
		for (String string : resultArr) {
			System.out.print(string + " ");
		}
	}
}
