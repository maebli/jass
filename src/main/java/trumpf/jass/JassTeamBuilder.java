package trumpf.jass;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import trumpf.cardgame.Player;
import trumpf.cardgame.Team;
import trumpf.cardgame.TeamBuilder;

public class JassTeamBuilder implements TeamBuilder{

	@Override
	public Map<Player,Team> build(Collection<Player> players) {
		Map<Player,Team> teams= new HashMap<Player,Team>();
		Team alpha=new JassTeam(true);
		Team beta= new JassTeam(false);
		Iterator<Player> playerIterator=players.iterator();
		
		teams.put(playerIterator.next(),alpha);
		teams.put(playerIterator.next(),alpha);
		teams.put(playerIterator.next(),beta);
		teams.put(playerIterator.next(),beta);
		
		return teams;
	}

}
