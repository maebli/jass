package jass.cardgame;


import jass.jass.JassTable;

public interface CardGame {
	
	public void play();
	public String getName();
	void setPlayers(JassTable table);
	
}
