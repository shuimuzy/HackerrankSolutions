package com.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DynamicSizeArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=1; i<=n; i++) {
			int length = sc.nextInt();
			List<Integer> value = new ArrayList<Integer>();
			
			if (length ==0) {
				value = null;
			} 
			else {
				for(int j=0; j<length; j++) {
					value.add(sc.nextInt());
				}
			}
			map.put(i, value);
		}
		
		//search by the provided x, y values
		int T = sc.nextInt();
		while (T-- >0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			List<Integer> values = map.get(x);
			if (values == null || values.size() < y)
				System.out.println("ERROR!");
			else
				System.out.println(values.get(y-1));
			
		}
		sc.close();

	}
}
