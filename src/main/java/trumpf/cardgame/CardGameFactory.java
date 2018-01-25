package trumpf.cardgame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import trumpf.jass.Jass;
import trumpf.jass.exception.JassCardGameDoesNotExistException;

public class CardGameFactory {

	private CardGameFactory(){};
	
	private static final Map<String, CardGame> CARD_GAME_MAP = 
		    Collections.unmodifiableMap(new HashMap<String, CardGame>() {{ 
		        put("Jass", (CardGame) new Jass());
			}});
	
	public static CardGame make(String name) throws JassCardGameDoesNotExistException{
		if(CARD_GAME_MAP.containsKey(name)){
			return CARD_GAME_MAP.get(name);
		}else{
			throw new JassCardGameDoesNotExistException(name);
		}
	}
	

}
