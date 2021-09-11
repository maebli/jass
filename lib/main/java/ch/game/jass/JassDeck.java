package ch.game.jass;

import ch.game.cardgame.Deck;

import java.util.ArrayList;
import java.util.Collections;

public class JassDeck implements Deck{
    
    private ArrayList<JassCard> deck = new ArrayList<JassCard>();
    
    public JassDeck(){
        for(int i = 0; i < JassCard.Rank.values().length; i++) {
            for(int j = 0; j < JassCard.Suit.values().length; j++) {
                JassCard tempCard = new JassCard(j, i);
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
        JassCard bottomCard = this.deck.get(0);
        String out = "Rank: " + bottomCard.getRank() + " Suit: " + bottomCard.getSuit();
        return out;
    }

	public boolean isNotEmpty() {
		return !this.deck.isEmpty();
	}
}
