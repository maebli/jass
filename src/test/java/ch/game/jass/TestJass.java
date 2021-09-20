package ch.game.jass;

import ch.game.cardgame.CardGameFactory;
import ch.game.jass.exception.JassCardGameDoesNotExistException;
import ch.game.jass.impartial.JassScoreKeeper;
import ch.game.jass.player.JassPlayer;
import ch.game.jass.player.JassPlayersBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TestJass {

	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	@Before
	public void setUp() throws JassCardGameDoesNotExistException{
		
		LOGGER.setLevel(Level.OFF);
		LOGGER.fine("Setting up	 Jass Test");
	}


	
	@Test
	public void testPlay() throws JassCardGameDoesNotExistException {
		Jass jass;
		jass=(Jass) CardGameFactory.make("Jass");
		ArrayList<JassPlayer> players = JassPlayersBuilder.build();
		JassTable table = new JassTable(players);
		jass.setPlayers(table);
		jass.play();
	}

	@Test
	public void multipleGames()  {
		AtomicInteger finished = new AtomicInteger();
		for(int i=0;i<300;i++){
			new Thread(() -> {
				try {
					Jass jass=(Jass) CardGameFactory.make("Jass");
					ArrayList<JassPlayer> players = JassPlayersBuilder.build();
					JassTable table = new JassTable(players);
					jass.setPlayers(table);
					jass.play();
				} catch (JassCardGameDoesNotExistException e) {
					e.printStackTrace();
				}
				finished.getAndIncrement();
			}).start();

		}

		while(finished.get()<300);
	}
	
	@Test
	public void testName(){
		assertEquals("Jass",new Jass().getName());
	}


	@Test
	public void testDumbPlayers() throws JassCardGameDoesNotExistException {

		Jass jass=(Jass) CardGameFactory.make("Jass");
		ArrayList<JassPlayer> players = JassPlayersBuilder.build();
		JassTable table = new JassTable(players);
		jass.setPlayers(table);
		JassScoreKeeper.JassGameResult result;

		jass.play();
		result=jass.getResult();

		for(int i=0;i<50;i++){
			jass.play();
			result.add(jass.getResult());
		}
		if(Jass.isVerbose()) {
			System.out.println(result);
		}
		float ratio=result.getWinLoseRatio();

		if(Jass.isVerbose()) {
			System.out.println(ratio);
		}

		assert(ratio <1.2 && ratio > 0.8);
	}

}
