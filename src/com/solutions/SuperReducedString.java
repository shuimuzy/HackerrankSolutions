package com.solutions;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/reduced-string/problem
 * @author TianS1
 * Remote the same pair chars from the string.
 * eg: aaabccddd → abccddd → abddd → abd
 * output:abd 
 */
public class SuperReducedString {

	static String superReducedString(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			
			if (!stack.isEmpty() && ch == (stack.peek())) {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		
		String result="";
		if (stack.isEmpty()) {
			result = "Empty String";
		} else {
			for (char ch : stack) {
				result += String.valueOf(ch);
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		String result = superReducedString(s);
		
		System.out.println(result);
	}

}
