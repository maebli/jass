package ch.game.jass.player;


import java.util.ArrayList;


public class JassPlayersBuilder{

	boolean humanPlayerInclude=false;

	public ArrayList<JassPlayer> build() {
		
		JassPlayer michael;
		
		if(humanPlayerInclude){
			michael=new HumanJassPlayer();
		}else{
			michael=new StupidJassPlayer();
		}
		michael.assignName("Michael");
		JassPlayer ellie=new StupidJassPlayer();
		ellie.assignName("Ellie");
		JassPlayer max= new StupidJassPlayer();
		max.assignName("Max");
		JassPlayer hans= new StupidJassPlayer();
		hans.assignName("Hans");
		
		ArrayList<JassPlayer> players = new ArrayList<JassPlayer>();
		
		players.add(michael);
		players.add(ellie);
		players.add(max);
		players.add(hans);
		
		return players;
	}
	
	public void activateHumanPlayer(){
		humanPlayerInclude=true;
	}

}
