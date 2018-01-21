package trumpf.cardgame;

import java.util.Map;

public interface CardGame {
	
	public void play();
	public void setTeams(Map<Player,Team> teams);
	public String getName();
	
}
