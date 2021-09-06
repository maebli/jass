package ch.game.jass;


import ch.game.cardgame.CardGame;
import ch.game.jass.impartial.JassGameModerator;
import ch.game.jass.impartial.JassScoreKeeper;
import ch.game.jass.player.JassHand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jass implements CardGame{
	
	private static final Logger LOGGER = Logger.getLogger(Jass.class.getName());

	private static final String GAME_NAME = "Jass";

    public enum GameMode{
    	OBEN,
    	UNTEN,
    	SCHELLE_TRUMPF,
		SCHILTEN_TRUMPF,
    	EICHEL_TRUMPF,
    	ROSE_TRUMPF
    }
    
    private JassTable table;
    
	public Jass(){
		LOGGER.log(Level.FINE, "New Jass game created.");
	}

	public void play() {
		
		JassGameModerator.dealHands(table);
		JassGameModerator.letPlayerChooseGameMode();



        for (int i = 0; i < JassHand.JASS_HAND_SIZE; i++) {
			System.out.println("\u001B[31m Round "+(i+1)+"\u001B[0m");
			JassGameModerator.moderateRound(table);
		}
		
		System.out.println(JassScoreKeeper.getGameScoreAsString(table));
	}

	@Override
	public String getName() {
		return GAME_NAME;
	}


	@Override
	public void setPlayers(JassTable table) {
        this.table=table;
	}


	
	


}