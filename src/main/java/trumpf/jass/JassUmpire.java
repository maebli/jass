package trumpf.jass;

import trumpf.cardgame.Umpire;

public class JassUmpire implements Umpire {

	public static boolean abidesByTheRules(JassMove nextMove) {
		boolean moveAbidesByTheRules=true;
		for(JassRule rule:JassRules.getRules()){
			moveAbidesByTheRules&=rule.abeidsByTheRule(nextMove);
		}
		return moveAbidesByTheRules;
	}

	public static JassPlayer determineWinner(JassTable table){
		//TODO: finish implementation
		return table.getPlayers().get(0);
	}
}
