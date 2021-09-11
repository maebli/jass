package ch.game.cardgame;

public interface Card {

    int getRank();

    int getSuit();
	void setSuit(int suit);
	void setRank(int rank);
	
}
