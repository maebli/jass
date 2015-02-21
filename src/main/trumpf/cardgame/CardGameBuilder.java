package trumpf.cardgame;

import java.util.Collection;


public interface CardGameBuilder {
	
	public CardGameBuilder setTable(Table table);
	public CardGameBuilder setRules(Collection<Rule> rules);
	public CardGame build(CardGameBuilder builder);
}
