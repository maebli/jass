package trumpf.jass;

import trumpf.cardgame.exception.CardSetIsFullException;

public class StupidJassPlayer implements JassPlayer {

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

	@Override
	public JassCard playCard(JassTrick trick) {
		JassMove move =new JassMove();
		move.setTrick(trick);
		move.setPlayer(this);
		for(JassCard card:hand.getAllCards()){
			move.setCard(card);
			if(JassUmpire.abidesByTheRules(move)){
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

}
