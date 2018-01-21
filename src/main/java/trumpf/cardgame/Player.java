package trumpf.cardgame;

import trumpf.jass.JassCard;

public interface Player {

	void dealCard(JassCard removeTopCard);
	void assignName(String name);

}
