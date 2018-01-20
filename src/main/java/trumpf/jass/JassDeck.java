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
            // TODO Auto-generated method stub

    }
    
    public int getDeckSize(){
        return vecDeck.size();
    }

}
