package trumpf.jass;



import java.util.ArrayList;

import trumpf.cardgame.PlayersBuilder;

public class JassPlayersBuilder implements PlayersBuilder{

	@Override
	public ArrayList<JassPlayer> build() {
		
		JassPlayer michael=new StupidJassPlayer();
		JassPlayer fritz=new StupidJassPlayer();
		JassPlayer max= new StupidJassPlayer();
		JassPlayer hans= new StupidJassPlayer();
		
		ArrayList<JassPlayer> players = new ArrayList<JassPlayer>();
		players.add(michael);
		players.add(fritz);
		players.add(max);
		players.add(hans);
		
		return players;
	}

}
