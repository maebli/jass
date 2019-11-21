package jass.jass;

import static org.junit.Assert.*;

import jass.jass.impartial.JassGameModerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jass.jass.JassCard.Rank;
import jass.jass.JassCard.Suit;

public class TestJassCard {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testComparingCards() {
		
		JassCard eichelAss = new JassCard(Suit.EICHEL,Rank.ASS);
		JassCard eichelKoenig = new JassCard(Suit.EICHEL,Rank.KOENIG);
		JassCard rosenAss = new JassCard(Suit.ROSEN,Rank.ASS);
		
		JassGameModerator.setGameMode(Jass.GameMode.OBEN);
		
		assertTrue(eichelAss.compareTo(eichelKoenig)==1);
		assertTrue(eichelKoenig.compareTo(eichelAss)==-1);
		assertTrue(eichelAss.compareTo(rosenAss)==-1);
		assertTrue(eichelKoenig.compareTo(rosenAss)==-1);
		assertTrue(rosenAss.compareTo(eichelAss)==-1);
		
		JassGameModerator.setGameMode(Jass.GameMode.UNTEN);
		
		assertTrue(eichelAss.compareTo(eichelKoenig)==-1);
		assertTrue(eichelKoenig.compareTo(eichelAss)==1);
		
		
		
	}

}
