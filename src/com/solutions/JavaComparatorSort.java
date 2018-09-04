package com.solutions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;


public class JavaComparatorSort {
	
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//        int[] arr = new int[n];
//        HashSet<Integer> set = new HashSet<>();
//        
//        for(int i=0; i<n;i++) {
//        	arr[i]=scan.nextInt();
//        }
//        
//        int largest=0; 
//        for(int j=0; j< (n-m+1); j++) {
//        	for(int t=0; t<m; t++) {
//        		set.add(arr[j+t]);
//        	}
//        	largest = Math.max(largest, set.size());
//        	set.clear();
//        }
//        System.out.println(largest);
		
		HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> deque     = new ArrayDeque<>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            /* Remove old value (if necessary) */
            if (i >= m) {
                int old = deque.removeFirst();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.merge(old, -1, Integer::sum);
                }
            }
            
            /* Add new value */
            int num = scan.nextInt();
            deque.addLast(num);
            map.merge(num, 1, Integer::sum);
            
            max = Math.max(max, map.size());
            
            /* If all integers are unique, we have found our largest
               possible answer, so we can break out of loop */
            if (max == m) {
                break;
            }
        }
        
        scan.close();
        System.out.println(max);
	}
	
}

