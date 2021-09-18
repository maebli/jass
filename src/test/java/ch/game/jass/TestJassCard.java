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

		JassTable table = new JassTable();

		JassCard eichelAss = new JassCard(JassCard.Suit.EICHEL, JassCard.Rank.ASS);
		JassCard eichelKoenig = new JassCard(JassCard.Suit.EICHEL, JassCard.Rank.KOENIG);
		JassCard rosenAss = new JassCard(JassCard.Suit.ROSEN, JassCard.Rank.ASS);
		JassCard rosenUnter = new JassCard(JassCard.Suit.ROSEN, JassCard.Rank.UNTER);
		JassCard rosenNell = new JassCard(JassCard.Suit.ROSEN, JassCard.Rank.C9);

		eichelAss.setTable(table);
		eichelKoenig.setTable(table);
		rosenAss.setTable(table);
		rosenUnter.setTable(table);
		rosenNell.setTable(table);

		table.setGameMode(JassTable.GameMode.OBEN);
		
		assertTrue(eichelAss.compareTo(eichelKoenig)==1);
		assertTrue(eichelKoenig.compareTo(eichelAss)==-1);
		assertTrue(eichelAss.compareTo(rosenAss)==-1);
		assertTrue(eichelKoenig.compareTo(rosenAss)==-1);
		assertTrue(rosenAss.compareTo(eichelAss)==-1);

		table.setGameMode(JassTable.GameMode.UNTEN);
		
		assertTrue(eichelAss.compareTo(eichelKoenig)==-1);
		assertTrue(eichelKoenig.compareTo(eichelAss)==1);


		table.setGameMode(JassTable.GameMode.ROSE_TRUMPF);


		assertTrue( rosenUnter.compareTo(rosenAss)>0);
		assertTrue( rosenAss.compareTo(rosenUnter)<0);

		assertTrue( rosenNell.compareTo(rosenAss)>0);
		assertTrue( rosenAss.compareTo(rosenNell)<0);

		assertTrue( rosenAss.compareTo(eichelAss)>0);
		
	}

}
