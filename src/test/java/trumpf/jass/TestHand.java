package trumpf.jass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import trumpf.cardgame.Card;
import trumpf.cardgame.exception.CardSetIsFullException;

public class TestHand {

	private JassHand jassHand;
	@Before
	public void setUp() throws Exception {
		jassHand=new JassHand();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJassHand() throws CardSetIsFullException {
		for(int i=0;i<JassHand.JASS_HAND_SIZE;i++){
			JassCard c= new JassCard(0,0);
			jassHand.addCards(c);
		}
		System.out.println(jassHand);
		try{
			jassHand.addCards(new JassCard(0,0));
			fail(); // hand is full
		}catch(CardSetIsFullException e){
		}
	}

}
