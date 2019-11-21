package jass.cardgame;

import java.util.Collection;

import jass.jass.rules.JassRule;



public interface CardGameBuilder {
	
	public CardGameBuilder setRules(Collection<JassRule> rules);
	public CardGame build(CardGameBuilder builder);
	
}
