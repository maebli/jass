package trumpf.jass;

import java.util.Collection;
import java.util.Map;

import trumpf.cardgame.CardGame;
import trumpf.cardgame.CardGameBuilder;
import trumpf.cardgame.GameModerator;
import trumpf.cardgame.Player;
import trumpf.cardgame.Rule;
import trumpf.cardgame.Table;
import trumpf.cardgame.Team;
import trumpf.jass.JassCard;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jass implements CardGame{
	
	private static final Logger LOGGER = Logger.getLogger(Jass.class.getName());

	private static final String GAME_NAME = "Jass";
	private static final String GAME_DESCRIPTION = "Jass";
    
    private static Map<Player, Team> teams;
    
	public Jass(){
		LOGGER.log(Level.FINE, "New Jass game created.");
	}

	public void play() {
		JassGameModerator.dealHands(teams);
	}

	@Override
	public String getName() {
		return GAME_NAME;
	}


	@Override
	public void setTeams(Map<Player, Team> teams) {
        this.teams=teams;
	}


	
	


}