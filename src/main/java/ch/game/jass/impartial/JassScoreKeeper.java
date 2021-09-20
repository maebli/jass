package ch.game.jass.impartial;

import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.player.JassPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JassScoreKeeper {

	
	private Map<JassPlayer,Integer> playerScores = new HashMap<JassPlayer,Integer>();
	
	private JassPlayer lastWinner;
	
	public void addToPile(JassPlayer player, JassTrick trick) {
		
		if(playerScores.containsKey(player)){
			int score=playerScores.get(player);
			score+=trick.getValue();
			playerScores.put(player, score);
		}else{
			playerScores.put(player,trick.getValue());
		}
		
		lastWinner=player;
	}
	
	public int getTeamScore(JassTable.JassTeam team){
		
		int score=0;

		JassPlayer p1 = team.getPlayers().get(0);
		JassPlayer p2 = team.getPlayers().get(1);

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

	public JassGameResult getGameScoreAsString(JassTable table) {

		JassGameResult result = new JassGameResult(table.getTeams());

		return result;
	}

	public class JassGameResult {

		private Map<JassTable.JassTeam,Integer> score;

		public JassGameResult( List<JassTable.JassTeam> teams){

			this.score = new HashMap<>();

			score.put(teams.get(0),getTeamScore(teams.get(0)));
			score.put(teams.get(1),getTeamScore(teams.get(1)));
		}

		public Map<JassTable.JassTeam,Integer> getScores() {
			return score;
		}

		public void add(JassTable.JassTeam team, int score) {
			this.score.replace(team,this.score.get(team)+score);
		}

		public void add(JassGameResult results) {
			for(JassTable.JassTeam team:score.keySet()){
				this.score.replace(team,score.get(team)+results.getScores().get(team));
			}
		}

		@Override
		public String toString(){
			StringBuilder s = new StringBuilder();

			for(JassTable.JassTeam team:score.keySet()){
				s.append(team+" "+ score.get(team) +" Points");
			}

			return s.toString();
		}

		public float getWinLoseRatio(){

			List<Float> i = new ArrayList();

			for(JassTable.JassTeam team:score.keySet()){
				i.add(Float.valueOf(score.get(team)));
			}

			return (i.get(0)/i.get(1));
		}
	}


}
