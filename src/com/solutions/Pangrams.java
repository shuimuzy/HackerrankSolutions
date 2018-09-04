package com.solutions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next().toLowerCase();
		scan.close();
		
		HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                set.add(ch);
            }
        }

        System.out.println(set.size() == 26 ? "pangram" : "not pangram");
		
//		Set<Character> set = new HashSet<>();
//		for (int i = 0; i < str.length(); i++) {
//			char ch = str.charAt(i);
//			if (Character.isLetter(ch)) {
//				set.add(ch);
//			}
//		}
//		System.out.println(set.size() == 26 ? "pangram" : "not pangram");
	}

}
