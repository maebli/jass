package ch.game.jass.impartial;


import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.player.JassMove;
import ch.game.jass.player.JassPlayer;
import ch.game.jass.rules.JassRule;
import ch.game.jass.rules.JassRules;

public class JassUmpire{

	public static boolean abidesByTheRules(JassMove nextMove) {
		boolean moveAbidesByTheRules=true;
		for (JassRule rule : JassRules.getRules()) {
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
		JassPlayer winner = table.getPlayers(JassGameModerator.getCurrentStartPlayer()).get(winningPlayerIndex);
		
		System.out.println(winningCard+" played by "+winner+" wins round.");
		
		return winner;
	}
}
