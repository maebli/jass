package ch.game.cardgame;

import ch.game.jass.Jass;
import ch.game.jass.exception.JassCardGameDoesNotExistException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CardGameFactory {

	private static final Map<String, CardGame> CARD_GAME_MAP =
		    Collections.unmodifiableMap(new HashMap<String, CardGame>() {
		    	/**
				 *
				 */
				private static final long serialVersionUID = 4061341226052762099L;

				{
					put("Jass", new Jass());
			}});

	private CardGameFactory() {
	}

	public static CardGame make(String name) throws JassCardGameDoesNotExistException {
		if(CARD_GAME_MAP.containsKey(name)){
			return CARD_GAME_MAP.get(name);
		}else{
			throw new JassCardGameDoesNotExistException(name);
		}
	}
	

}
