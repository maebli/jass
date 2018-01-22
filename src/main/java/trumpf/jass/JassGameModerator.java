package trumpf.jass;

import java.util.Map;
import java.util.logging.Logger;

import trumpf.cardgame.GameModerator;
import trumpf.cardgame.Player;
import trumpf.cardgame.Team;

public class JassGameModerator implements GameModerator{
	
	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	private static Player startingPlayer;
	
	private static final JassCard startingCard=
			new JassCard(JassCard.Suit.EICHEL.ordinal()
					,JassCard.Rank.BANNER.ordinal());

	public static void dealHands(Map<Player, Team> teams) {
		
		JassDeck deck= new JassDeck();
		deck.shuffle();
		
		int i=0;
		
		while(deck.isNotEmpty()){
			for(Player player:teams.keySet()){
				i++;
				JassCard card=deck.removeTopCard();
				LOGGER.info("dealing card "+i+" "+card);
				if(card.equals(startingCard)){
					startingPlayer=player;
				}
				player.dealCard(card);
			}
		}
		LOGGER.info("Starting player ="+startingPlayer);
		
	}

	public static void whosTurnIsIt(Map<Player, Team> teams) {
		// TODO Auto-generated method stub
		
	}

	
}
