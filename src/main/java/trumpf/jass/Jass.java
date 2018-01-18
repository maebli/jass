package trumpf.jass;

import java.util.Collection;
import java.util.Map;

import trumpf.cardgame.CardGame;
import trumpf.cardgame.CardGameBuilder;
import trumpf.cardgame.Player;
import trumpf.cardgame.Rule;
import trumpf.cardgame.Table;
import trumpf.cardgame.Team;

public class Jass implements CardGame{

	private static final String GAME_NAME = "Jass";

	public Jass(){

	}
	

	
	public void play() {
	}

	@Override
	public String getName() {
		return GAME_NAME;
	}



	@Override
	public void addPlayers(Collection<Player> players) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setTeams(Map<Player, Team> teams) {
		// TODO Auto-generated method stub
		
	}
	


}