package ch.game.jass.player;


import java.util.ArrayList;
import java.util.List;


public class JassPlayersBuilder{

	private static int player_number = 4;
	private final static List<String> names=new ArrayList<String>();

	static{
		names.add("Michael");
		names.add("Ellie");
		names.add("Max");
		names.add("Karen");
	}

	public ArrayList<JassPlayer> build() {

		ArrayList<JassPlayer> players = new ArrayList<JassPlayer>();
		for(int i=0;i<player_number;i++){
			JassPlayer p=new StupidJassPlayer();;
			p.assignName(names.get(i));
			players.add(p);
		}
		return players;
	}

}
