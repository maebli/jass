package trumpf.jass;

import java.util.Map;

import trumpf.cardgame.GameModerator;
import trumpf.cardgame.Player;
import trumpf.cardgame.Team;

public class JassGameModerator implements GameModerator{

	public static void dealHands(Map<Player, Team> teams) {
		
		JassDeck deck= new JassDeck();
		deck.shuffle();
		int i=0;
		while(deck.isNotEmpty()){
			for(Player player:teams.keySet()){
				i++;
				System.out.println("dealing card "+i);
				player.dealCard(deck.removeTopCard());
			}
		}
		
	}

	
}
