package ch.game.jass.player;

import ch.game.cardgame.Card;
import ch.game.jass.JassCard;
import ch.game.jass.exception.JassCardNotInSetException;
import ch.game.jass.exception.JassCardSetIsFullException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class JassHand{
	
	public static int JASS_HAND_SIZE = 9;
	
	private Set<JassCard> cards = new HashSet<JassCard>();

	public void addCards(JassCard card) throws JassCardSetIsFullException {
		if(cards.size()<(JASS_HAND_SIZE)){
			cards.add(card);
		}else{
			throw new JassCardSetIsFullException();
		}
	}

	public void addCards(Set<JassCard> cards) throws JassCardSetIsFullException {
		if((this.cards.size()+cards.size())<(JASS_HAND_SIZE)){
			cards.addAll(cards);
		}else{
			throw new JassCardSetIsFullException();
		}
	}

	public Set<JassCard> getAllCards() {
		return cards;
	}

	public void removeCard(JassCard card) throws JassCardNotInSetException {
		if(!cards.remove(card)){
			throw new JassCardNotInSetException();
		}
	}
	
	public boolean containsSuit(int suit){
		for(Card card:cards){
			if(card.getSuit()==suit){
				return true;
			}
		}
		return false;
	}

	public boolean containsCard(JassCard card){
		for(Card c:cards){
			if(c.getSuit() == card.getSuit() &&
					c.getRank() == card.getRank()){
				return true;
			}
		}
		return false;
	}

	
	public String toString(){
		String cardsAsString="Cards \r\n \n";
		for(Card card:cards){
			cardsAsString+=card;
			cardsAsString+="\r\n";
		}
		return cardsAsString;
	}

	public Stream<JassCard> stream(){
		return cards.stream();
	}

	public int size(){
		return cards.size();
	}
}
