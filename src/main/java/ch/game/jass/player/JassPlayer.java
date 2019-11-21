package ch.game.jass.player;


import ch.game.jass.JassCard;
import ch.game.jass.JassTrick;

public interface JassPlayer {

	void dealCard(JassCard removeTopCard);
	void assignName(String name);
	JassHand getHand();
	boolean canPlaySuit(int suit);
	JassCard playCard(JassTrick trick);
	int chooseGameMode();
	
}
