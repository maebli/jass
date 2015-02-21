package trumpf.cardgame;

import java.util.Collection;
import java.util.Map;

public interface CardGame {
	
	public void play();
	public void addPlayers(Collection<Player> players);
	public void setTeams(Map<Player,Team> teams);
	public String getName();
	
	
}
