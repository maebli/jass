package ch.game.cardgame;

import ch.game.jass.rules.JassRule;

import java.util.Collection;


public interface CardGameBuilder {

	CardGameBuilder setRules(Collection<JassRule> rules);

	CardGame build(CardGameBuilder builder);
	
}
