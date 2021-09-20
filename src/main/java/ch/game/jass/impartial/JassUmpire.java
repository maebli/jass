package ch.game.jass.impartial;


import ch.game.jass.Jass;
import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.JassTrick;
import ch.game.jass.player.JassMove;
import ch.game.jass.player.JassPlayer;
import ch.game.jass.rules.JassRule;
import ch.game.jass.rules.JassRules;

public class JassUmpire{

	public static boolean abidesByTheRules(JassMove nextMove, JassTable.GameMode mode) {
		boolean moveAbidesByTheRules=true;
		for (JassRule rule : JassRules.getRules()) {
            moveAbidesByTheRules &= rule.followsRule(nextMove,mode);
		}
		return moveAbidesByTheRules;
	}

	public static JassPlayer determineWinner(JassTable table,JassGameModerator mod, JassTable.GameMode mode){
		
		JassTrick trick=table.getTrick();
		
		if(trick.size()!=JassTrick.TRICK_MAX_SIZE){
			System.err.println("Umpire needs fully populated trick to determine winner.");
			System.exit(0);
		}
		
		JassCard winningCard=trick.getWinningCard(mode);
		int winningPlayerIndex=trick.get().indexOf(winningCard);
		JassPlayer winner = table.getPlayers(mod.getCurrentStartPlayer()).get(winningPlayerIndex);

		if(Jass.isVerbose()) {
			System.out.println(winningCard + " played by " + winner + " wins round.");
		}
		return winner;
	}
}
