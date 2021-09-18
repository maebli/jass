package ch.game.jass;


import ch.game.cardgame.CardGame;
import ch.game.jass.impartial.JassGameModerator;
import ch.game.jass.impartial.JassScoreKeeper;
import ch.game.jass.player.JassHand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jass implements CardGame{

	private static final int MAJOR_VERSION = 0;
	private static final int MINOR_VERSION = 0;
	private static final int PATCH_VERSION = 8;


	private static final Logger LOGGER = Logger.getLogger(Jass.class.getName());

	private static final String GAME_NAME = "Jass";
    
    private JassTable table;
    
	public Jass(){
		LOGGER.log(Level.FINE, "New Jass game created.");
	}

	public void play() {

		JassGameModerator mod = new JassGameModerator();
		JassScoreKeeper keeper = new JassScoreKeeper();

		mod.registerScoreKeeper(keeper);
		mod.dealHands(table);
		mod.letPlayerChooseGameMode(table);

        for (int i = 0; i < JassHand.JASS_HAND_SIZE; i++) {
			mod.moderateRound(table);
		}

		System.out.println(keeper.getGameScoreAsString(table));

	}

	@Override
	public String getVersion() {
		return "v"+MAJOR_VERSION+"."+MINOR_VERSION+"."+PATCH_VERSION;
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