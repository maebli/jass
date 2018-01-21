package trumpf.jass;

import java.util.Vector;
import trumpf.cardgame.Deck;
import trumpf.jass.JassCard;

public class JassDeck implements Deck{
    
    private Vector vecDeck = new Vector();
    
    public JassDeck(){
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 4; j++) {
                JassCard tempCard = new JassCard(i, j);
                this.vecDeck.add(tempCard);
            }
        }
    }

    
    @Override
    public void shuffle() {
        Vector ShuffleDeck = new Vector();
        int shuffleRepetitions = 100;
        for(int i=0; i < shuffleRepetitions; i++){
            while(this.vecDeck.size()>0) {
                //Takes randomly the frist or the last element of the Deck and
                //generates a new one.
                if(Math.random()<0.5){
                    ShuffleDeck.add(removeTopCard());
                }else {
                    ShuffleDeck.add(removeBottomCard());
                }
            }
            //Copy files back to original deck
            int numOfElements = ShuffleDeck.size();
            for(int j=0; j < numOfElements;j++){
                this.vecDeck.add((JassCard)ShuffleDeck.remove(0));
            }
        }
    }
    
    public int getDeckSize(){
        return this.vecDeck.size();
    }
    
    public JassCard removeTopCard(){
        int lastElement = this.vecDeck.size()-1;
        return (JassCard)this.vecDeck.remove(lastElement);   
    }
    public JassCard removeBottomCard(){
        return (JassCard)this.vecDeck.remove(0);   
    }
    
    public String showBottomCard(){
        JassCard bottomCard = (JassCard)this.vecDeck.firstElement();
        String out = "Name: " + bottomCard.getName() + " Color: " + bottomCard.getColor();
        return out;
    }
}
