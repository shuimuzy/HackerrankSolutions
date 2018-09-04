package com.solutions;

import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = sc.nextLine().split(" ");
			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		sc.close();
		int result = hourglassSum(arr);
		System.out.println(result);

	}

	static int hourglassSum(int[][] a) {
		int largest= Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int temp = a[i][j] + a[i][j+1] + a[i][j+2]
						 		   + a[i+1][j+1] + 
						   a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
				if (temp > largest) {
					largest = temp;
				}
			}
		}
		return largest;
	}
}
