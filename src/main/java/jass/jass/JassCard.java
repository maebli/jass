package jass.jass;

import java.util.HashMap;
import java.util.Map;

import jass.cardgame.Card;
import jass.jass.impartial.JassGameModerator;


public class JassCard implements Card,Comparable<JassCard>{
	
    private int suit;
    private int rank;


	public enum Suit {
        EICHEL,
        ROSEN,
        SCHELLEN,
        SCHILTEN
    }
    
    public enum Rank {
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
    
    private final static Map<Integer,String> ranksNames;
    private final static Map<Integer,String> suitsNames;
    private final static Map<Integer,Integer> obenValues;
    private final static Map<Integer,Integer> untenValues;
    private final static Map<Integer,Integer> trumpfValues;
    
    static{
    	Map<Integer,Integer> values=new HashMap<Integer,Integer>();
    	values.put(Rank.C6.ordinal(),0);
    	values.put(Rank.C7.ordinal(),0);
    	values.put(Rank.C8.ordinal(),8);
    	values.put(Rank.C9.ordinal(),0);
    	values.put(Rank.BANNER.ordinal(),10);
    	values.put(Rank.UNTER.ordinal(),2);
    	values.put(Rank.OBER.ordinal(),3);
    	values.put(Rank.KOENIG.ordinal(),4);
    	values.put(Rank.ASS.ordinal(),11);
    	obenValues=values;
    }
    
    static{
    	Map<Integer,Integer> values=new HashMap<Integer,Integer>();
    	values.put(Rank.C6.ordinal(),11);
    	values.put(Rank.C7.ordinal(),0);
    	values.put(Rank.C8.ordinal(),8);
    	values.put(Rank.C9.ordinal(),0);
    	values.put(Rank.BANNER.ordinal(),10);
    	values.put(Rank.UNTER.ordinal(),2);
    	values.put(Rank.OBER.ordinal(),3);
    	values.put(Rank.KOENIG.ordinal(),4);
    	values.put(Rank.ASS.ordinal(),0);
    	untenValues=values;
    }
    
    static{
    	Map<Integer,Integer> values=new HashMap<Integer,Integer>();
    	values.put(Rank.C6.ordinal(),0);
    	values.put(Rank.C7.ordinal(),0);
    	values.put(Rank.C8.ordinal(),0);
    	values.put(Rank.C9.ordinal(),14);
    	values.put(Rank.BANNER.ordinal(),10);
    	values.put(Rank.UNTER.ordinal(),20);
    	values.put(Rank.OBER.ordinal(),3);
    	values.put(Rank.KOENIG.ordinal(),4);
    	values.put(Rank.ASS.ordinal(),11);
    	trumpfValues=values;
    }
    
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
			
		}else if(Jass.GameMode.SCHELLE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
		}else if(Jass.GameMode.SCHILTE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
		}else if(Jass.GameMode.EICHEL_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			
		}
		return 0;
	}
	
	int getValue(){
		if(Jass.GameMode.OBEN.ordinal() ==
				JassGameModerator.getGameMode()){
			return obenValues.get(rank);
		}else if(Jass.GameMode.UNTEN.ordinal() ==
				JassGameModerator.getGameMode()){
			return untenValues.get(rank);
		}else if(rank==Rank.C8.ordinal()){
			return 0;
		}else if(Jass.GameMode.ROSE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			if(suit==Suit.ROSEN.ordinal()){
				return trumpfValues.get(rank);
			}
		}else if(Jass.GameMode.SCHELLE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			if(suit==Suit.SCHELLEN.ordinal()){
				return trumpfValues.get(rank);
			}
		}else if(Jass.GameMode.SCHILTE_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			if(suit==Suit.SCHILTEN.ordinal()){
				return trumpfValues.get(rank);
			}
		}else if(Jass.GameMode.EICHEL_TRUMPF.ordinal() ==
				JassGameModerator.getGameMode()){
			if(suit==Suit.EICHEL.ordinal()){
				return trumpfValues.get(rank);
			}
		}
		return obenValues.get(rank);
		
	}
   
   
}
