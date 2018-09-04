package com.solutions;

import java.util.Scanner;

public class LeapGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		while (num-- >0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();
			int[] a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = scan.nextInt();
			}
			System.out.println(isResolved(a,leap,0) ? "Yes" : "No");
		}
		scan.close();
	}

    /* Basically a depth-first search (DFS). 
    Marks each array value as 1 when visiting (Side-effect: alters array) */
	public static boolean isResolved(int[] arr, int m, int i) {
		/* Base Cases */
		if(i<0 || arr[i] == 1)
			return false;
		else if (i>=arr.length -1 || i+m >=arr.length)
			return true;
		
		arr[i] = 1;// marks as visited
		
		/* Recursive Cases (Tries +m first to try to finish game quickly) */
		return isResolved(arr, m, i+m) || isResolved(arr, m, i+1) || isResolved(arr, m, i-1);
	}
	
}
