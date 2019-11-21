package jass.jass;


import jass.jass.exception.JassCardNotInSetException;

public class StupidJassPlayer extends BasicJassPlayer {

	
	public StupidJassPlayer(){
		super();
	}

	@Override
	public JassCard playCard(JassTrick trick) {
		JassHand hand=getHand();
		JassMove move =new JassMove();
		move.setTrick(trick);
		move.setPlayer(this);
		for(JassCard card:hand.getAllCards()){
			move.setCard(card);
			if(JassUmpire.abidesByTheRules(move)){
				try {
					hand.removeCard(card);
				} catch (JassCardNotInSetException e) {
					System.err.println("Fatal error, player is doing stupid things.");
					System.exit(0);
				}
				return card;
			}
		}
		System.err.println("No legal card found,rules are wrong..");
		System.exit(0);
		return null;
	}

	@Override
	public int chooseGameMode() {
		return Jass.GameMode.OBEN.ordinal();
	}

}
