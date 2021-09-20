package ch.game.jass.player;


import ch.game.jass.JassTableView;
import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;

public interface JassPlayer extends JassTableViewer {

	void dealCard(JassCard removeTopCard);
	void assignName(String name);
	JassHand getHand();
	boolean canPlaySuit(int suit);
	JassCard playCard(JassTrick trick);
	JassTable.GameMode chooseGameMode();
	boolean decidedToChooseGameMode();
	void setToTable(JassTableView tableview);
	
}
