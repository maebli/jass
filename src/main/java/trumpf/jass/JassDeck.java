package trumpf.jass;

import java.util.Collections;
import java.util.Vector;

import trumpf.cardgame.Deck;
import trumpf.jass.JassCard;

public class JassDeck implements Deck{
    
    private Vector<JassCard> deck = new Vector<JassCard>();
    
    public JassDeck(){
        for(int i = 0; i < JassCard.Rank.values().length; i++) {
            for(int j = 0; j < JassCard.Suit.values().length; j++) {
                JassCard tempCard = new JassCard(i, j);
                this.deck.add(tempCard);
            }
        }
    }

    
    @Override
    public void shuffle() {
    	Collections.shuffle(deck);
    }
    
    public int getDeckSize(){
        return this.deck.size();
    }
    
    public JassCard removeTopCard(){
        int lastElement = this.deck.size()-1;
        return this.deck.remove(lastElement);   
    }
    public JassCard removeBottomCard(){
        return this.deck.remove(0);   
    }
    
    public String showBottomCard(){
        JassCard bottomCard = this.deck.firstElement();
        String out = "Rank: " + bottomCard.getRank() + " Suit: " + bottomCard.getSuit();
        return out;
    }

	public boolean isNotEmpty() {
		return !this.deck.isEmpty();
	}
}
