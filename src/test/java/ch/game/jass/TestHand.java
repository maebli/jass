package ch.game.jass;

import ch.game.jass.exception.JassCardSetIsFullException;
import ch.game.jass.player.JassHand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

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
	public void testJassHand() throws JassCardSetIsFullException {
		for(int i=0;i<JassHand.JASS_HAND_SIZE;i++){
			JassCard c= new JassCard(0,0);
			jassHand.addCards(c);
		}

		if(Jass.isVerbose()) {
			System.out.println(jassHand);
		}

		try{
			jassHand.addCards(new JassCard(0,0));
			fail(); // hand is full
		}catch(JassCardSetIsFullException e){
		}
	}

}
