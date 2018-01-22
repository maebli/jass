package trumpf.jass;

import java.util.Vector;
import java.util.logging.Logger;

import trumpf.cardgame.GameModerator;
import trumpf.cardgame.Player;

public class JassGameModerator implements GameModerator{
	
	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	private static Player nextPlayer;
	
	private static final JassCard startingCard=
			new JassCard(JassCard.Suit.EICHEL.ordinal()
					,JassCard.Rank.BANNER.ordinal());

	public static void dealHands(JassTable table) {
		
		JassDeck deck= new JassDeck();
		deck.shuffle();
		
		int i=0;
		
		while(deck.isNotEmpty()){
			for(Player player:table.getPlayers()){
				i++;
				JassCard card=deck.removeTopCard();
				LOGGER.info("dealing card "+i+" "+card);
				if(card.equals(startingCard)){
					nextPlayer=player;
				}
				player.dealCard(card);
			}
		}
		
		LOGGER.info("Starting player ="+nextPlayer);
		
	}


	public static void moderateRound(JassTable table) {
		LOGGER.info("Playing new round");
		for(Player player:table.getPlayers(nextPlayer)){
			player.playCard();
		}
		
	}



	
}
