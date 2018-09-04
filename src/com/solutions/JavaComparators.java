package com.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.solutions.Player;

public class JavaComparators {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        //choose class to save data when collections are not suitable.
        Player[] player = new Player[n];
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        
        Comparator<Player> comp = new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				if (o1.score == o2.score) {
					return o1.name.compareTo(o2.name);
				} else {
					return o2.score - o1.score;
				}
			}
		};
		
		//lamda expression
//		Comparator<Player> comp = (o1, o2) -> {
//			if (o1.score == o2.score) {
//				return o1.name.compareTo(o2.name);
//			} else {
//				return o2.score - o1.score;
//			}
//		};
		
        Arrays.sort(player, comp);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
	}
	
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
