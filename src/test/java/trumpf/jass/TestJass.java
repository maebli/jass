package trumpf.jass;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import org.junit.Before;
import org.junit.Test;

import trumpf.cardgame.CardGame;
import trumpf.cardgame.CardGameFactory;
import trumpf.cardgame.Player;
import trumpf.cardgame.PlayersBuilder;
import trumpf.cardgame.Team;
import trumpf.cardgame.TeamBuilder;
import trumpf.cardgame.exception.CardGameDoesNotExistException;

public class TestJass {

	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	private Jass jass;
	
	@Before
	public void setUp() throws CardGameDoesNotExistException{
		
		Handler handler=new StreamHandler(System.out, new SimpleFormatter());
		
		// change to Level.INFO for info only
		// Use System.out only for Game UI
		handler.setLevel(Level.ALL); 
		
		LOGGER.addHandler(handler);
		
		LOGGER.fine("Setting up Jass Test");

		
		jass=(Jass) CardGameFactory.make("Jass");
		
		PlayersBuilder playersBuilder=new JassPlayersBuilder();
		
		Vector<Player> players = playersBuilder.build();
		JassTable table = new JassTable(players);
		
		jass.setPlayers(table);

	}


	
	@Test
	public void testPlay(){
		jass.play();
	}
	
	@Test
	public void testName(){
		assertEquals("Jass",jass.getName());
	}

}
