package trumpf.jass;

import java.util.HashSet;
import java.util.Set;

import trumpf.cardgame.Card;
import trumpf.cardgame.Hand;
import trumpf.cardgame.exception.CardNotInSetException;
import trumpf.cardgame.exception.CardSetIsFullException;

public class JassHand implements Hand{
	
	public static int JASS_HAND_SIZE = 9;
	
	private Set<Card> cards = new HashSet<Card>();

	@Override
	public void addCards(Card card) throws CardSetIsFullException {
		if(cards.size()<(JASS_HAND_SIZE)){
			cards.add(card);
		}else{
			throw new CardSetIsFullException();
		}
	}

	@Override
	public void addCards(Set<Card> cards) throws CardSetIsFullException {
		if((this.cards.size()+cards.size())<(JASS_HAND_SIZE)){
			cards.addAll(cards);
		}else{
			throw new CardSetIsFullException();
		}
	}

	@Override
	public Set<Card> getAllCards() {
		return cards;
	}

	@Override
	public void removeCard(Card card) throws CardNotInSetException {
		if(!cards.remove(card)){
			throw new CardNotInSetException();
		}
	}
	
	public String toString(){
		String cardsAsString="Cards \r\n \n";
		for(Card card:cards){
			cardsAsString+="Suit:"+card.getSuit()+"  Rank:"+card.getRank();
			cardsAsString+="\r\n";
		}
		return cardsAsString;
	}

}
