package ch.game.jass.player;


import ch.game.jass.JassTableView;
import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;

public interface JassPlayer extends JassTableViewer {

	void dealCard(final JassCard card);
	void assignName(final String name);
	JassHand getHand();
	boolean canPlaySuit(final int suit);
	JassCard playCard(final JassTrick trick);
	JassTable.GameMode chooseGameMode();
	boolean decidedToChooseGameMode();
	void setToTable(JassTableView tableview);
	
}
