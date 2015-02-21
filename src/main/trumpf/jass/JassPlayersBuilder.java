package trumpf.jass;

import java.util.ArrayList;
import java.util.Collection;

import trumpf.cardgame.Player;
import trumpf.cardgame.PlayersBuilder;

public class JassPlayersBuilder implements PlayersBuilder{

	@Override
	public Collection<Player> build() {
		Player michael=new StupidJassPlayer();
		Player fritz=new StupidJassPlayer();
		Player max= new StupidJassPlayer();
		Player hans= new StupidJassPlayer();
		
		Collection<Player> players = new ArrayList<Player>();
		players.add(michael);
		players.add(fritz);
		players.add(max);
		players.add(hans);
		return players;
	}

}
