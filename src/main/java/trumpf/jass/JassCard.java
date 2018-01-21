package trumpf.jass;

import trumpf.cardgame.Card;

public class JassCard implements Card{
	
    private int suit;
    private int rank;
    
    public static enum Suit {
        EICHEL,
        ROSEN,
        SCHELLEN,
        SCHILTEN
    }
    
    public static enum Rank {
        C6,
        C7,
        C8,
        C9,
        BANNER,
        UNTER,
        OBER,
        KOENIG,
        ASS
    }
    
    public JassCard(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    @Override
	public int getSuit() {
		return this.suit;
	}
    
    @Override
	public int getRank() {
		return this.rank;
	}
    
    @Override
	public void setSuit(int suit) {
		this.suit = suit;
	}    
        
   @Override
	public void setRank(int rank) {
		this.rank = rank;
	}  
}
