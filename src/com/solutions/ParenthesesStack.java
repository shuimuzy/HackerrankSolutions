package com.solutions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class ParenthesesStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		while (sc.hasNext()) {
			String str=sc.nextLine();
			System.out.println(isBalanced(map, str) ? "True" : "False");
			
		}
		sc.close();
	}
	
	public static boolean isBalanced(HashMap<Character, Character> map, String exp) {

		if (exp.length()%2 == 1)
			return false;
		ArrayDeque<Character> deque= new ArrayDeque<>();
		for(int i=0; i < exp.length(); i++) {
			Character ch = exp.charAt(i);
			if (map.containsKey(ch)) {
				deque.push(ch);
			} else if (deque.isEmpty() || ch != map.get(deque.pop())) {
				return false;
			}
		}
		return deque.isEmpty();
	}
}
