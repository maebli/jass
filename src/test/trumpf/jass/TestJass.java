package trumpf.jass;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

	Jass jass;
	
	@Before
	public void setUp() throws CardGameDoesNotExistException{
		
		jass=(Jass) CardGameFactory.make("Jass");
		
		PlayersBuilder playersBuilder=new JassPlayersBuilder();
		TeamBuilder teamBuilder=new JassTeamBuilder();
		
		Collection<Player> players = playersBuilder.build();
		Map<Player, Team> teams = teamBuilder.build(players);
		
		jass.addPlayers(players);
		jass.setTeams(teams);

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
