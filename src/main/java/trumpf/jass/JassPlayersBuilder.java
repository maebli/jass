package trumpf.jass;



import java.util.ArrayList;

import trumpf.cardgame.PlayersBuilder;

public class JassPlayersBuilder implements PlayersBuilder{

	@Override
	public ArrayList<JassPlayer> build() {
		
		JassPlayer michael=new StupidJassPlayer();
		michael.assignName("Michael");
		JassPlayer fritz=new StupidJassPlayer();
		fritz.assignName("Fritz");
		JassPlayer max= new StupidJassPlayer();
		max.assignName("Max");
		JassPlayer hans= new StupidJassPlayer();
		hans.assignName("Hans");
		
		ArrayList<JassPlayer> players = new ArrayList<JassPlayer>();
		players.add(michael);
		players.add(fritz);
		players.add(max);
		players.add(hans);
		
		return players;
	}

}
