package trumpf.cardgame;

import java.util.Collection;
import java.util.Map;

import trumpf.jass.JassPlayer;

public interface TeamBuilder {
	
	public Map<JassPlayer,Team> build(Collection<JassPlayer> players);
}
