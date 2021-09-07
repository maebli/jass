package ch.game.jass.player;

import ch.game.jass.JassCard;
import ch.game.jass.JassTrick;
import ch.game.jass.exception.JassCardNotInSetException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HumanJassPlayer extends BasicJassPlayer {

	Scanner reader = new Scanner(System.in); 

	@Override
	public JassCard playCard(JassTrick trick) {
		JassHand hand=getHand();
		System.out.println("Your hand:");
		int i=0;
		ArrayList<JassCard> cards = new ArrayList<JassCard>(hand.getAllCards());
		
		Collections.sort(cards);
		
		for(JassCard card:cards){
			System.out.println(i++ +":"+card+" ");
		}
		
		System.out.println("Enter number of card: ");
		int n = reader.nextInt(); 
		JassCard card=cards.get(n);
		try {
			hand.removeCard(card);
		} catch (JassCardNotInSetException e) {
			System.err.println("card doesn't exist in players hand.");
			System.exit(0);
		}
		return card;
	}

	@Override
	public int chooseGameMode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean decidedToChooseGameMode(){
		return true;
	}
	

}
