package ch.game.jass.player;


import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.exception.JassCardNotInSetException;
import ch.game.jass.impartial.JassUmpire;

public class StupidJassPlayer extends BasicJassPlayer {

	public StupidJassPlayer(){
		super();
	}

	@Override
	public JassCard playCard(final JassTrick trick) {
		JassHand hand=getHand();
		JassMove move =new JassMove();
		move.setTrick(trick);
		move.setPlayer(this);
		for(JassCard card:hand.getAllCards()){
			move.setCard(card);
			if(JassUmpire.abidesByTheRules(move,getTableView().getGameMode())){
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
	public JassTable.GameMode chooseGameMode() {
		return JassTable.GameMode.values()[(int)(Math.random()*JassTable.GameMode.values().length)];
	}

	@Override
	public boolean decidedToChooseGameMode() {
		return (Math.random()*2)>1;
	}

	@Override
	public void reactToNewCardInTrick(JassCard card, Player player) {

	}

	@Override
	public void reactToEndOfGame() {

	}
}
