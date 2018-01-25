package trumpf.jass;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import trumpf.jass.JassCard;
import trumpf.jass.JassDeck;
import trumpf.jass.exception.JassDeckIsNotComplete;

public class TestDeck {
    
    private JassDeck testdeck;
    private JassDeck testshuffledeck;
    private JassCard testcard;
    
    @Before
    public void setUp() throws Exception {
        testdeck = new JassDeck();
        testshuffledeck = new JassDeck();
        testcard = new JassCard(0,0);

    }
 
    @Test
    public void testJassDeck() throws JassDeckIsNotComplete {
        //Check deck size
        if(testdeck.getDeckSize()!=36){
            System.out.println("Deck is created with " + testdeck.getDeckSize() + " cards instead of 36!");
            fail();
        }
        //Compare decks before shuffle
        if(!(testdeck.showBottomCard()).equals(testshuffledeck.showBottomCard())){
            System.out.println("TestDeck and TestShuffleDeck are not the same before shuffle!");
            System.out.println("TestShuffleDeck Bottom Card: " + testshuffledeck.showBottomCard());
            System.out.println("TestDeck Bottom Card: " + testdeck.showBottomCard());
            fail();
        }
        
        testshuffledeck.shuffle();
        //Check deck size after shuffle
        if(testshuffledeck.getDeckSize()!=36){
            System.out.println("Lost or gained cards because deck was shuffled!");
            System.out.println("Actual number of cards in the testshuffledeck is: " + testshuffledeck.getDeckSize());
            fail();
        }
        //Compare decks after shuffle
        if((testshuffledeck.showBottomCard()).equals(testdeck.showBottomCard())){
            System.out.println("Top cards of both decks are equal after shuffle one of them!");
            System.out.println("TestShuffleDeck Bottom Card: " + testshuffledeck.showBottomCard());
            System.out.println("TestDeck Bottom Card: " + testdeck.showBottomCard());
            fail();
        }
        //Check if cards can be removed 
        testcard = testdeck.removeTopCard();
        if(testdeck.getDeckSize()!=35){
            System.out.println("Top card of the deck was not possible to remove!");
            fail();
        }
        testcard = testdeck.removeBottomCard();
        if(testdeck.getDeckSize()!=34){
            System.out.println("Bottom card of the deck was not possible to remove!");
            fail();
        }
        
    }        
}
