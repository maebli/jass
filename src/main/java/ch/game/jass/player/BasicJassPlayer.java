package ch.game.jass.player;

import ch.game.cardgame.TableView;
import ch.game.jass.Jass;
import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.exception.JassCardSetIsFullException;

public abstract class BasicJassPlayer implements JassPlayer {

	private JassHand hand;
	private String name = "Unnamed Jassplayer";
	private TableView tableView;

	public BasicJassPlayer(){
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
	public abstract JassCard playCard(JassTrick trick);

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
	public abstract JassTable.GameMode chooseGameMode();

	@Override
	public void giveTableView(TableView tableView){
		this.tableView = tableView;
	}

	public TableView getTableView() {
		return tableView;
	}
}
