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

public class Jass implements CardGame{

	private static final String GAME_NAME = "Jass";
    
    private static Map<Player, Team> teams;
    
    
	public Jass(){
		
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