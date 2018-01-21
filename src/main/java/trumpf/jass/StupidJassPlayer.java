package trumpf.jass;

import trumpf.cardgame.Player;
import trumpf.cardgame.exception.CardSetIsFullException;

public class StupidJassPlayer implements Player {

	private JassHand hand;
	private String name;
	
	public StupidJassPlayer(){
		this.hand=new JassHand();
	}
	
	@Override
	public void dealCard(JassCard card) {
		try {
			hand.addCards(card);
		} catch (CardSetIsFullException e) {
			System.err.println("Fatal error. Player "+name+" was dealt too many cards.");
			System.exit(0);
		}
	}

	@Override
	public void assignName(String name) {
		this.name=name;
	}

}
