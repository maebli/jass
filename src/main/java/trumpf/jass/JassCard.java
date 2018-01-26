package trumpf.jass;

import java.util.HashMap;
import java.util.Map;

import trumpf.cardgame.Card;
import trumpf.jass.Jass;


public class JassCard implements Card,Comparable<JassCard>{
	
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
    
    private static Map<Integer,String> ranksNames;
    private static Map<Integer,String> suitsNames;
    
    static{
    	Map<Integer,String> ranksGerman=new HashMap<Integer,String>();
    	ranksGerman.put(Rank.C6.ordinal(),"Sechs");
    	ranksGerman.put(Rank.C7.ordinal(),"Sieben");
    	ranksGerman.put(Rank.C8.ordinal(),"Acht");
    	ranksGerman.put(Rank.C9.ordinal(),"Neun");
    	ranksGerman.put(Rank.BANNER.ordinal(),"Banner");
    	ranksGerman.put(Rank.UNTER.ordinal(),"Unter");
    	ranksGerman.put(Rank.OBER.ordinal(),"Ober");
    	ranksGerman.put(Rank.KOENIG.ordinal(),"König");
    	ranksGerman.put(Rank.ASS.ordinal(),"Ass");
    	ranksNames=ranksGerman;
    }
    
    static{
    	Map<Integer,String> suitsGerman=new HashMap<Integer,String>();
    	suitsGerman.put(Suit.EICHEL.ordinal(),"Eichel");
    	suitsGerman.put(Suit.ROSEN.ordinal(),"Rosen");
    	suitsGerman.put(Suit.SCHELLEN.ordinal(),"Schellen");
    	suitsGerman.put(Suit.SCHILTEN.ordinal(),"Schilten");
    	suitsNames=suitsGerman;
    }
    
    public JassCard(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

	public JassCard(Suit suit, Rank rank) {
		this.suit = suit.ordinal();
		this.rank = rank.ordinal();
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
   
   public String toString(){
	   return "\u001B[34m"+suitsNames.get(suit)+" "+
			   "\u001B[35m"+
			   ranksNames.get(rank)+
			    "\u001B[0m";
   }
   
   @Override
   public boolean equals(Object o) {
	   if(getClass()==o.getClass()){
		   JassCard card=(JassCard) o;
		  if((this.rank == card.rank) &&
		     (this.suit == card.suit)){
			  return true;
		  }
	   }
	   return false;
   }

	@Override
	public int compareTo(JassCard o) {
		if(Jass.GameMode.OBEN.ordinal() ==
				JassGameModerator.getGameMode()){
			
			if(o.getSuit()==suit){
				return rank-o.getRank();
			}else{
				return -1;
			}
			
		}else if(Jass.GameMode.UNTEN.ordinal() ==
				JassGameModerator.getGameMode()){
			
			if(o.getSuit()==suit){
				return o.getRank()-rank;
			}else{
				return -1;
			}
			
		}else if(Jass.GameMode.ROSE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
			if(o.getSuit()==suit){
				return rank-o.getRank();
			}else{
				if(o.getSuit()==Suit.ROSEN.ordinal()){
					return 1;
				}else{
					return -1;
				}
			}
			
		}else if(Jass.GameMode.SCHAELLE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
		}else if(Jass.GameMode.SCHILTE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
		}else if(Jass.GameMode.EICHEL_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
		}
		return 0;
	}
   
   
}
