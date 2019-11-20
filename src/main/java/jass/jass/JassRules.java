package jass.jass;

import java.util.HashSet;
import java.util.Set;


public class JassRules {

	/*
	 *  "Farben"
	 *  
	 *  Only for OBEN / UNTEN games at the moment
	 *  
	 */
	
	private static Set<JassRule> jassRules=new HashSet<JassRule>();
	
	static{
		jassRules.add(new CorrectSuitMustBePlayed());
	}
	
	public static Set<JassRule> getRules(){
		return jassRules;
	}
	
	public static class CorrectSuitMustBePlayed implements JassRule{

		@Override
		public boolean abeidsByTheRule(JassMove move) {
			
			if(move.getTrick().isEmtpy()){
				return true;
			}
			
			if(JassGameModerator.isTrumpfGame()){
				System.err.println("Trumpf not implemented yet.");
				System.exit(0);
			}
			
			JassPlayer player=move.getPlayer();
			JassCard card=move.getCard();
			int suitOfTrick=move.getSuitOfTrick();
			
			if(player.canPlaySuit(suitOfTrick)){
				if(card.getSuit()==suitOfTrick){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}
		
	}
	

}
