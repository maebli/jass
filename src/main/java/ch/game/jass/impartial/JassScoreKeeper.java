package ch.game.jass.impartial;

import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.player.JassPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JassScoreKeeper {

	
	static Map<JassPlayer,Integer> playerScores = new HashMap<JassPlayer,Integer>();
	
	static JassPlayer lastWinner;
	
	public static void addToPile(JassPlayer player, JassTrick trick) {
		
		if(playerScores.containsKey(player)){
			int score=playerScores.get(player);
			score+=trick.getValue();
			playerScores.put(player, score);
		}else{
			playerScores.put(player,trick.getValue());
		}
		
		lastWinner=player;
	}
	
	public static int getTeamScore(JassPlayer p1, JassPlayer p2){
		
		int score=0;
		
		if((p1==lastWinner)||(p2==lastWinner)){
			score+=5;
		}
		if(playerScores.containsKey(p1)){
			score +=playerScores.get(p1);
		}
		
		if(playerScores.containsKey(p2)){
			score +=playerScores.get(p2);
		}
		
		
		if(score==157){
			score+=100;
		}
		
		return score;
	}

	public static String getGameScoreAsString(JassTable table) {
		
		String score = "";
		
		ArrayList<JassPlayer> players=table.getPlayers();
		
		int scoreT1=getTeamScore(players.get(0),players.get(2));
		int scoreT2=getTeamScore(players.get(1),players.get(3));
				
		score += "Team 1:("+players.get(0)+", "+players.get(2)+") score="+scoreT1;
		score += " Team 2:("+players.get(1)+", "+players.get(3)+") score="+scoreT2;
		
		return score;
	}
	
}
