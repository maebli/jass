package trumpf.cardgame;

import java.util.Collection;
import java.util.Map;

public interface TeamBuilder {
	
	public Map<Player,Team> build(Collection<Player> players);
}
