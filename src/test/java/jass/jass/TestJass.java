package jass.jass;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;


import org.junit.Before;
import org.junit.Test;

import jass.cardgame.CardGameFactory;

import jass.jass.exception.JassCardGameDoesNotExistException;

public class TestJass {

	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	private Jass jass;
	
	@Before
	public void setUp() throws JassCardGameDoesNotExistException{
		
		//Handler handler=new StreamHandler(System.out, new SimpleFormatter());
		
		// change to Level.INFO for info only
		// Use System.out only for Game UI
		
		//handler.setLevel(Level.OFF); 
		
		//LOGGER.addHandler(handler);
		
		LOGGER.setLevel(Level.OFF);
		
		LOGGER.fine("Setting up Jass Test");

		
		jass=(Jass) CardGameFactory.make("Jass");
		
		JassPlayersBuilder playersBuilder=new JassPlayersBuilder();
		
		ArrayList<JassPlayer> players = playersBuilder.build();
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
