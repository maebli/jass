package trumpf.cardgame;

import java.util.Set;

import trumpf.cardgame.exception.CardNotInSetException;
import trumpf.cardgame.exception.CardSetIsFullException;
import trumpf.jass.JassCard;

public interface Hand {
	
	public void addCards(JassCard card) throws CardSetIsFullException;
	public void addCards(Set<JassCard> card) throws CardSetIsFullException;
	public Set<JassCard> getAllCards();
	public void removeCard(JassCard card) throws CardNotInSetException;

}
