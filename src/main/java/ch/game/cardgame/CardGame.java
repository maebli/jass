package ch.game.cardgame;


import ch.game.jass.JassTable;

public interface CardGame {

	void play();
	String getVersion();
	String getName();
	void setPlayers(JassTable table);
	
}
