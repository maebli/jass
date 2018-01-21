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
		for(int i=0;i<7;i++){
			Card c= new JassCard(0, 0);
			jassHand.addCards(c);
		}
		System.out.println(jassHand);
	}

}
