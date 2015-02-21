package trumpf.cardgame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import trumpf.cardgame.exception.CardGameDoesNotExistException;
import trumpf.jass.Jass;

public class CardGameFactory {

	private CardGameFactory(){};
	
	private static final Map<String, CardGame> CARD_GAME_MAP = 
		    Collections.unmodifiableMap(new HashMap<String, CardGame>() {{ 
		        put("Jass", (CardGame) new Jass());
			}});
	
	public static CardGame make(String name) throws CardGameDoesNotExistException{
		if(CARD_GAME_MAP.containsKey(name)){
			return CARD_GAME_MAP.get(name);
		}else{
			throw new CardGameDoesNotExistException(name);
		}
	}
	

}
