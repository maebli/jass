package trumpf.jass;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


import trumpf.jass.JassDeck;
import trumpf.cardgame.exception.JassDeckIsNotComplete;

public class TestDeck {
    
    private JassDeck testdeck;
    
    @Before
    public void setUp() throws Exception {
        testdeck = new JassDeck();
    }
 
    @Test
    public void testJassDeck() throws JassDeckIsNotComplete {
        if(testdeck.getDeckSize()!=36){
            System.out.println("Deck is created with " + testdeck.getDeckSize() + " cards instead of 36!");
            fail();
        }
    }        
}
