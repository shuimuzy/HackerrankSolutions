package com.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.math.BigDecimal;

public class JavaBigDecimal {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        String [] s = new String[n];
	        for (int i = 0; i < n; i++) {
	            s[i] = sc.next();
	        }
	        sc.close();
	        
	        //solution 1:
	        // We want to sort in descending order while preserving the contents 
	        // of each String. A comparator can achieve this for us. We convert  
	        // to BigDecimal inside our comparator so that the change is not 
	        // permanent and our String's form for each number is preserved.
//	        Comparator<String> customComparator = new Comparator<String>() {
//	            @Override
//	            public int compare(String s1, String s2) {
//	                BigDecimal a = new BigDecimal(s1);
//	                BigDecimal b = new BigDecimal(s2);
//	                return b.compareTo(a); // descending order
//	            }
//	        };
//
	      //solution 2:
	        //ascending order: (o1,o2) -> new BigDecimal(o1).compareTo(new BigDecimal(o2))
	        Comparator<String> customComparator = (o1,o2) -> new BigDecimal(o2).compareTo(new BigDecimal(o1)); // descending order
	       
	        Arrays.sort(s, 0, n, customComparator);
	        
	        //Output
	        for (int i = 0; i < n; i++) {
	            System.out.println(s[i]);
	        }

	}

}
