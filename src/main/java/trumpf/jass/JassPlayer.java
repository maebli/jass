package trumpf.jass;


public abstract interface JassPlayer {

	void dealCard(JassCard removeTopCard);
	void assignName(String name);
	JassHand getHand();
	boolean canPlaySuit(int suit);
	JassCard playCard(JassTrick trick);
	int chooseGameMode();
	
}
