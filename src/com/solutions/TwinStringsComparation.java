package com.solutions;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;

/*
 *规则：每个字符串的奇数可以任意交换位置，偶数位也可以任意交换位置
 *比较上下两组的每一个字符串是否相等，相等输出YES，不等输出NO
 * 
Sample input
====================
4
cdgae 
alfaw
adgafbbf
qawerqewr 
4
caedg 
aaflw
gdabbbff
raeerqwwq
 */

public class TwinStringsComparation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list1.add(sc.next());
		}
		
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			list2.add(sc.next());
		}
		sc.close();
		
//		List<String> result = judgeTwins(list1, list2);
//		for (String string : result) {
//			System.out.println(string);
//		}
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(compare2String(list1.get(i), list2.get(i)) ? "YES" : "NO");
		}
		
	}
	
	private static boolean compare2String(String a, String b) {
		List<Character> oddA = new ArrayList<>();
		List<Character> evenA = new ArrayList<>();
		List<Character> oddB = new ArrayList<>();
		List<Character> evenB = new ArrayList<>();
		
		
		
		if (a.length() != b.length()) {
			return false;
		} else {
			for (int i = 0; i < a.length(); i++) {
				Character c1 = a.charAt(i);
				if (c1 % 2 != 0) {
					oddA.add(c1);
				} else {
					evenA.add(c1);
				}
				
				Character c2 = b.charAt(i);
				if (c2 % 2 != 0) {
					oddB.add(c2);
				} else {
					evenB.add(c2);
				}
				
			}
			
			Collections.sort(oddA);
			Collections.sort(evenA);
			Collections.sort(oddB);
			Collections.sort(evenB);
			
			String strA = oddA.toString().concat(evenA.toString());
			String strB = oddB.toString().concat(evenB.toString());
			
			if (strA.equals(strB)) {
			return true; 
			} else {
				return false;
			}
			
		}
		
		
//		return false;
	}

	static List<String> judgeTwins(List<String> a, List<String> b){
		int size = a.size(); // a and b is the same size
		
		List<String> result = new ArrayList<>();
		for (int t = 0; t < size; t++) {
			String strA = a.get(t);
			String strB = b.get(t);
			
			String res = compareTString(strA, strB);
			result.add(res);
			
		}
		
		return result;
	}
	
	static String compareTString(String strA, String strB) {
		String res="";
		List<Character> oddA = new ArrayList<>();
		List<Character> evenA = new ArrayList<>();
		
		List<Character> oddB = new ArrayList<>();
		List<Character> evenB = new ArrayList<>();
		char[] arrA = strA.toCharArray();
		char[] arrB = strB.toCharArray();
		
		if (strA.length() != strB.length()) {
			res="NO";
		} else {//length is the same
			
			//traverse a string
			for (int i = 0; i < strA.length(); i++) {
				if (i % 2 != 0) {
					oddA.add(arrA[i]);
				} else {
					evenA.add(arrA[i]);
				}
			}
			
			//traverse b string
			for (int j = 0; j < strB.length(); j++) {
				if (j % 2 != 0) {
					oddB.add(arrB[j]);
				} else {
					evenB.add(arrB[j]);
				}
			}
			
			Collections.sort(oddA);
			Collections.sort(evenA);
			Collections.sort(oddB);
			Collections.sort(evenB);
			
			String aSorted = oddA.toString() + evenA.toString();
			String bSorted = oddB.toString() + evenB.toString();
			if (aSorted.equals(bSorted)) {
				res = "YES";
			} else {
				res = "NO";
			}
		}
		return res;
	}
}
