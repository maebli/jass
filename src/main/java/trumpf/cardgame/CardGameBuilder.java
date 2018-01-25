package trumpf.cardgame;

import java.util.Collection;

import trumpf.jass.JassRule;



public interface CardGameBuilder {
	
	public CardGameBuilder setTable(Table table);
	public CardGameBuilder setRules(Collection<JassRule> rules);
	public CardGame build(CardGameBuilder builder);
	
}
