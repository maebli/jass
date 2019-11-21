package ch.game;

import ch.game.cardgame.CardGameFactory;
import ch.game.jass.Jass;
import ch.game.jass.JassTable;
import ch.game.jass.exception.JassCardGameDoesNotExistException;
import ch.game.jass.player.JassPlayer;
import ch.game.jass.player.JassPlayersBuilder;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JassCLI {

	private static Jass jass;
	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	public static void main(String[] args){

		try {
			jass=(Jass) CardGameFactory.make("Jass");
		} catch (JassCardGameDoesNotExistException e) {
			System.err.println("Game doesn't exist..");
			System.exit(0);
		}
		
		LOGGER.setLevel(Level.OFF);
		
		JassPlayersBuilder playersBuilder=new JassPlayersBuilder();
		
		playersBuilder.activateHumanPlayer();
		
		ArrayList<JassPlayer> players = playersBuilder.build();
		JassTable table = new JassTable(players);
		
		jass.setPlayers(table);
		
		jass.play();


	}


}
