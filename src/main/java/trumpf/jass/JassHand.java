package trumpf.jass;

import java.util.HashSet;
import java.util.Set;

import trumpf.cardgame.Card;
import trumpf.cardgame.Hand;
import trumpf.cardgame.exception.CardNotInSetException;
import trumpf.cardgame.exception.CardSetIsFullException;

public class JassHand implements Hand{
	
	public static int JASS_HAND_SIZE = 9;
	
	private Set<JassCard> cards = new HashSet<JassCard>();

	@Override
	public void addCards(JassCard card) throws CardSetIsFullException {
		if(cards.size()<(JASS_HAND_SIZE)){
			cards.add(card);
		}else{
			throw new CardSetIsFullException();
		}
	}

	@Override
	public void addCards(Set<JassCard> cards) throws CardSetIsFullException {
		if((this.cards.size()+cards.size())<(JASS_HAND_SIZE)){
			cards.addAll(cards);
		}else{
			throw new CardSetIsFullException();
		}
	}

	@Override
	public Set<JassCard> getAllCards() {
		return cards;
	}

	@Override
	public void removeCard(JassCard card) throws CardNotInSetException {
		if(!cards.remove(card)){
			throw new CardNotInSetException();
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
	
	public String toString(){
		String cardsAsString="Cards \r\n \n";
		for(Card card:cards){
			cardsAsString+=card;
			cardsAsString+="\r\n";
		}
		return cardsAsString;
	}

}
