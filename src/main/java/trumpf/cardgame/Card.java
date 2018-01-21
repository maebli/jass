package trumpf.cardgame;

public interface Card {
	
    public int getRank();
    public int getSuit();
	void setSuit(int suit);
	void setRank(int rank);
	
}
