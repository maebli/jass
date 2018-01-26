package trumpf.jass;


public class JassUmpire{

	public static boolean abidesByTheRules(JassMove nextMove) {
		boolean moveAbidesByTheRules=true;
		for(JassRule rule:JassRules.getRules()){
			moveAbidesByTheRules&=rule.abeidsByTheRule(nextMove);
		}
		return moveAbidesByTheRules;
	}

	public static JassPlayer determineWinner(JassTable table){
		
		JassTrick trick=table.getTrick();
		
		if(trick.size()!=JassTrick.TRICK_MAX_SIZE){
			System.err.println("Umpire needs fully populated trick to determine winner.");
			System.exit(0);
		}
		
		JassCard winningCard=trick.getWinningCard();
		int winningPlayerIndex=trick.get().indexOf(winningCard);
		JassPlayer winner = table.getPlayers().get(winningPlayerIndex);
		
		System.out.println(winningCard+" played by "+winner+" wins round.");
		
		return winner;
	}
}
