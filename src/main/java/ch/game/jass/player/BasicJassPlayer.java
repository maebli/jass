package ch.game.jass.player;

import ch.game.jass.JassTableView;
import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.exception.JassCardSetIsFullException;

public abstract class BasicJassPlayer implements JassPlayer {

	private JassHand hand;
	private String name = "Unnamed Jassplayer";
	private JassTableView tableView;

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
	public void setToTable(JassTableView tableView){
		this.tableView = tableView;
	}

	public JassTableView getTableView() {
		return tableView;
	}

	@Override
	public String getName() {
		return name;
	}
}
