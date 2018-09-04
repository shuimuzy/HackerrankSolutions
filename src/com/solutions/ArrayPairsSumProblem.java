package com.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author TianS1
 * From an array, find pair whose sum is k. 
 * a = {2, 3, 6, 8, 10, 20, -9, 3, 8, 20, -7, 99}; k = 11;
 * Found 2 pairs (-9,20) (3,8), please note (3,8) (8,3) are the same pair
 * 
 */

public class ArrayPairsSumProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = {2, 3, 6, 8, 10, 20, -9, 3, 8, 20, -7, 99, 8,8,8};
		int k = 11;
		
		Arrays.sort(a);
		//[-9, -7, 2, 3, 3, 6, 8, 8,8,8,8 10, 20, 20, 99]
		
		int result = FindPairs(a, k);
		System.out.println("Found " + result + " pairs");

	}

	private static int FindPairs(int[] a, int k) {
		//define two indice left and right
		int left = 0;
		int right = a.length - 1;
		int count = 0; // the number of pairs found
		
		while (left < right) {
			if (a[left] == a[left + 1]) { //ignore repeated numbers
				left++;
				continue;
			} 
			
			if (a[right] == a[right -1]) { //ignore repeated numbers
				right--;
				continue;
			}
						
			if (a[left] + a[right] == k) {
				count++; 
				left++;
			} else if (a[left] + a[right] < k) {
				left++;
			} else {
				right--;
			}
		}
		return count;
	}

}
