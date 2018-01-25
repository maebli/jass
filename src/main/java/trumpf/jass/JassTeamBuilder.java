package trumpf.jass;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import trumpf.cardgame.Team;
import trumpf.cardgame.TeamBuilder;

public class JassTeamBuilder implements TeamBuilder{

	@Override
	public Map<JassPlayer,Team> build(Collection<JassPlayer> players) {
		
		Map<JassPlayer,Team> teams= new HashMap<JassPlayer,Team>();
		Team alpha=new JassTeam(true);
		Team beta= new JassTeam(false);
		Iterator<JassPlayer> playerIterator=players.iterator();
		
		teams.put(playerIterator.next(),alpha);
		teams.put(playerIterator.next(),alpha);
		teams.put(playerIterator.next(),beta);
		teams.put(playerIterator.next(),beta);
		
		return teams;
	}

}
