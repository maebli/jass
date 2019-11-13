package trumpf;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import trumpf.cardgame.CardGameFactory;
import trumpf.jass.Jass;
import trumpf.jass.JassPlayer;
import trumpf.jass.JassPlayersBuilder;
import trumpf.jass.JassTable;
import trumpf.jass.exception.JassCardGameDoesNotExistException;

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
