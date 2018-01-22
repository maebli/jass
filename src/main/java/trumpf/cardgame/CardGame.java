package trumpf.cardgame;

import java.util.Vector;

import trumpf.jass.JassTable;

public interface CardGame {
	
	public void play();
	public String getName();
	void setPlayers(JassTable table);
	
}
