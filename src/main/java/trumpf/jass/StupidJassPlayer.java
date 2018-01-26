package trumpf.jass;

import java.util.ArrayList;

import trumpf.jass.exception.JassCardNotInSetException;
import trumpf.jass.exception.JassCardSetIsFullException;

public class StupidJassPlayer implements JassPlayer {

	private JassHand hand;
	private String name = "Unnamed Jassplayer";
	
	public StupidJassPlayer(){
		this.hand=new JassHand();
	}
	
	@Override
	public void dealCard(JassCard card) {
		try {
			hand.addCards(card);
		} catch (JassCardSetIsFullException e) {
			System.err.println("Fatal error. Player "+name+" was dealt too many cards.");
			System.exit(0);
		}
	}

	@Override
	public void assignName(String name) {
		this.name=name;
	}

	@Override
	public JassCard playCard(JassTrick trick) {
		JassMove move =new JassMove();
		move.setTrick(trick);
		move.setPlayer(this);
		for(JassCard card:hand.getAllCards()){
			move.setCard(card);
			if(JassUmpire.abidesByTheRules(move)){
				try {
					hand.removeCard(card);
				} catch (JassCardNotInSetException e) {
					System.err.println("Fatal error, player is doing stupid things.");
					System.exit(0);
				}
				return card;
			}
		}
		System.err.println("No legal card found,rules are wrong..");
		System.exit(0);
		return null;
	}

	@Override
	public JassHand getHand() {
		return this.hand;
	}

	@Override
	public boolean canPlaySuit(int suit) {
		return hand.containsSuit(suit);
	}

	public String toString(){
		return "\u001B[32m"+name+"\u001B[0m";
	}

	@Override
	public int chooseGameMode() {
		return Jass.GameMode.OBEN.ordinal();
	}

}
