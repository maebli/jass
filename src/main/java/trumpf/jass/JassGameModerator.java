package trumpf.jass;

import java.util.Map;
import java.util.logging.Logger;

import trumpf.cardgame.GameModerator;
import trumpf.cardgame.Player;
import trumpf.cardgame.Team;

public class JassGameModerator implements GameModerator{
	
	private static final Logger LOGGER = Logger.getLogger("Logger");

	public static void dealHands(Map<Player, Team> teams) {
		
		JassDeck deck= new JassDeck();
		deck.shuffle();
		int i=0;
		while(deck.isNotEmpty()){
			for(Player player:teams.keySet()){
				i++;
				JassCard card=deck.removeTopCard();
				LOGGER.finer("dealing card "+i+" "+card);
				player.dealCard(card);
			}
		}
		
	}

	
}
