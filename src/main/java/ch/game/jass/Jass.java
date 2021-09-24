package ch.game.jass;


import ch.game.cardgame.CardGame;
import ch.game.jass.impartial.JassGameModerator;
import ch.game.jass.impartial.JassScoreKeeper;
import ch.game.jass.player.JassHand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jass implements CardGame{


	private static boolean verbose = false;

	private static final int MAJOR_VERSION = 0;
	private static final int MINOR_VERSION = 0;
	private static final int PATCH_VERSION = 11;


	private static final Logger LOGGER = Logger.getLogger(Jass.class.getName());

	private static final String GAME_NAME = "Jass";
    
    private JassTable table;

	private JassScoreKeeper.JassGameResult result;

	public Jass(){
		LOGGER.log(Level.FINE, "New Jass game created.");
	}

	public static boolean isVerbose() {
		return verbose;
	}

	/**
	 * The most important events are printed
	 * using System.out if this is set to true.
	 * @param verbose
	 */
	public static void setVerbose(final boolean verbose) {
		Jass.verbose = verbose;
	}

	/** This is the most important function
	 *  before running play, you must setPlayers(..)
	 *  This function creates a Moderator and and a
	 *  ScoreKeepr internally and plays JASS_HAND_SIZE
	 *  rounds of Jass until all players have played
	 *  all of their cards.
	 *
	 *  Once this function is complete you may fetch
	 *  the result using the function getResult()
	 */
	public void play() {

		JassGameModerator mod = new JassGameModerator();
		JassScoreKeeper keeper = new JassScoreKeeper();

		mod.registerScoreKeeper(keeper);
		mod.dealHands(table);
		mod.letPlayerChooseGameMode(table);

        for (int i = 0; i < JassHand.JASS_HAND_SIZE; i++) {
			mod.moderateRound(table);
		}

		result = keeper.getGameScoreAsString(table);
		if(Jass.isVerbose()) {
			System.out.println(result);
		}
	}


	@Override
	public String getVersion() {
		return MAJOR_VERSION+"."+MINOR_VERSION+"."+PATCH_VERSION;
	}

	@Override
	public String getName() {
		return GAME_NAME;
	}


	@Override
	public void setPlayers(final JassTable table) {
		this.table=table;
	}

	/**
	 * Returns the Result of the last game. If play()
	 * is called again the last round is overwritten
	 * in the same JassGameResult instance.
	 * @return
	 */
	public JassScoreKeeper.JassGameResult getResult() {
		return result;
	}
}