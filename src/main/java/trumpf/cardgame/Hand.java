package trumpf.cardgame;

import java.util.Set;

import trumpf.cardgame.exception.CardNotInSetException;
import trumpf.cardgame.exception.CardSetIsFullException;

public interface Hand {
	
	public void addCards(Card card) throws CardSetIsFullException;
	public void addCards(Set<Card> card) throws CardSetIsFullException;
	public Set<Card> getAllCards();
	public void removeCard(Card card) throws CardNotInSetException;

}
