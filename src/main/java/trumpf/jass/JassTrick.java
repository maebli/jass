package trumpf.jass;

import java.util.ArrayList;

import trumpf.cardgame.Trick;

public class JassTrick implements Trick{
	
	/* Trick is a "round" of four cards played see
	 * https://en.wikipedia.org/wiki/Trick-taking_game
	 */

	private static final int TRICK_MAX_SIZE = 4;
	
	private ArrayList<JassCard> trick=new ArrayList<JassCard>();
	
	void playCard(JassCard card){
		if(trick.size()<TRICK_MAX_SIZE){
			trick.add(card);
		}else{
			//TODO: throw an exception
			System.exit(0);
		}
	}
	
	public ArrayList<JassCard> getTrick() {
		return trick;
	}
	
	public int getSuitOfTrick(){
		return trick.get(0).getSuit();
	}
	
	public void clear(){
		trick.clear();
	}
}
