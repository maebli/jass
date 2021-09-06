package ch.game.jass;

import ch.game.jass.impartial.JassGameModerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestJassCard {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testComparingCards() {

		JassCard eichelAss = new JassCard(JassCard.Suit.EICHEL, JassCard.Rank.ASS);
		JassCard eichelKoenig = new JassCard(JassCard.Suit.EICHEL, JassCard.Rank.KOENIG);
		JassCard rosenAss = new JassCard(JassCard.Suit.ROSEN, JassCard.Rank.ASS);
		JassCard eichelUnter = new JassCard(JassCard.Suit.EICHEL,JassCard.Rank.UNTER);
		JassGameModerator.setGameMode(Jass.GameMode.OBEN);
		
		assertTrue(eichelAss.compareTo(eichelKoenig)==1);
		assertTrue(eichelKoenig.compareTo(eichelAss)==-1);
		assertTrue(eichelAss.compareTo(rosenAss)==-1);
		assertTrue(eichelKoenig.compareTo(rosenAss)==-1);
		assertTrue(rosenAss.compareTo(eichelAss)==-1);
		
		JassGameModerator.setGameMode(Jass.GameMode.UNTEN);
		
		assertTrue(eichelAss.compareTo(eichelKoenig)==-1);
		assertTrue(eichelKoenig.compareTo(eichelAss)==1);


		JassGameModerator.setGameMode(Jass.GameMode.EICHEL_TRUMPF);
		assertTrue(JassGameModerator.getGameMode() == Jass.GameMode.EICHEL_TRUMPF.ordinal());

		assertTrue( eichelUnter.compareTo(eichelAss)>0);
		
		
		
	}

}
