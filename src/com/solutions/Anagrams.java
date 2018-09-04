package com.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
	static boolean isAnagram(String a, String b) {
        // Complete the function
		if (a == null || b == null || a.length() != b.length())
			return false;
		
		char[] arrayA = a.toLowerCase().toCharArray();
		Arrays.sort(arrayA);
		char[] arrayB = b.toLowerCase().toCharArray();
		Arrays.sort(arrayB);
		String str1 = String.valueOf(arrayA);
		String str2 = String.valueOf(arrayB);
		return str1.equals(str2);
    }
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        
    }

}
