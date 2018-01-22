package trumpf.jass;


import java.util.Vector;

import trumpf.cardgame.Player;
import trumpf.cardgame.PlayersBuilder;

public class JassPlayersBuilder implements PlayersBuilder{

	@Override
	public Vector<Player> build() {
		
		Player michael=new StupidJassPlayer();
		Player fritz=new StupidJassPlayer();
		Player max= new StupidJassPlayer();
		Player hans= new StupidJassPlayer();
		
		Vector<Player> players = new Vector<Player>();
		players.add(michael);
		players.add(fritz);
		players.add(max);
		players.add(hans);
		
		return players;
	}

}
