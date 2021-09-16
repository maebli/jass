package ch.game.cardgame;

import ch.game.jass.Jass;
import ch.game.jass.exception.JassCardGameDoesNotExistException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CardGameFactory {

	private CardGameFactory() {
	}

	public static CardGame make(String name) throws JassCardGameDoesNotExistException {
		if(name.equals("Jass")){
			return new Jass();
		}else{
			throw new JassCardGameDoesNotExistException(name);
		}
	}
	

}
