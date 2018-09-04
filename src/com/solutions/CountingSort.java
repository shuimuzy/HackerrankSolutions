package com.solutions;

import java.util.Scanner;

public class CountingSort {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		printArray(countingSort(arr));
		scanner.close();
	}

	static int[] countingSort(int[] arr) {

		// count times of each number from 0 to 99
		// the length of arr can over 100
		int count[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// sort the arr and output it to result array.
		int[] result = new int[arr.length];
		int t = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				result[t++] = i;
			}
		}

		return result;
	}

	private static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
