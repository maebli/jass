package ch.game.jass;

import ch.game.jass.impartial.JassGameModerator;

import java.util.ArrayList;
import java.util.Collections;


public class JassTrick{
	
	/* Trick is a "round" of four cards played see
	 * https://en.wikipedia.org/wiki/Trick-taking_game
	 */

	public static final int TRICK_MAX_SIZE = 4;
	
	private ArrayList<JassCard> trick=new ArrayList<JassCard>();
	
	void playCard(JassCard card){
		if(trick.size()<TRICK_MAX_SIZE){
			trick.add(card);
		}else{
			//TODO: throw an exception
			System.exit(0);
		}
	}
	
	public ArrayList<JassCard> get() {
		return trick;
	}
	
	public int size(){
		return trick.size();
	}
	
	public boolean isEmtpy(){
		return trick.size()==0;
	}
	
	public int getSuit(){
		return trick.get(0).getSuit();
	}
	
	public void clear(){
		trick.clear();
	}
	
	public JassCard getWinningCard(){
		
		ArrayList<JassCard> sortedTrick = new ArrayList<JassCard>();

		for(JassCard card:trick){
			if(card.getSuit()==trick.get(0).getSuit()||
			   card.getSuit()== JassGameModerator.getTrumpfSuit()) {
				sortedTrick.add(card);
			}
		}
		
		Collections.sort(sortedTrick);
		
		return sortedTrick.get(sortedTrick.size()-1);
	}

	public Integer getValue() {
		int score=0;
		for(JassCard card:trick){
			score+=card.getValue();
		}
		return score;
	}
}
