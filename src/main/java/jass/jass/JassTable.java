package jass.jass;


import java.util.ArrayList;


public class JassTable{
	
	private static final int MAX_PLAYERS_AT_JASS_TABLE=4;
    private ArrayList<JassPlayer> players; 
    
    private JassTrick trick=new JassTrick();
    
    /*
     * Sitting arrangement
     * 
     *  (0)		(3)
     *     Trick
     *  (1)		(2)
     *  
     *  team a: 0,2
     *  team b: 1,3
     */
    

	public JassTable(ArrayList<JassPlayer> players){
    	if(players.size()!=MAX_PLAYERS_AT_JASS_TABLE) {
    		System.exit(0);
    	}
    	this.players=players;
    }
    
    public ArrayList<JassPlayer> getPlayers(){
    	return players;
    }
    
    public ArrayList<JassPlayer> getPlayers(JassPlayer firstPlayer){
    	
    	int index=players.indexOf(firstPlayer);
    	ArrayList<JassPlayer> orderedVector=new ArrayList<JassPlayer>();
    	
    	for(int i=0;i<players.size();i++){
    		orderedVector.add(players.get(index));
    		index=(index+1)%players.size();
    	}

    	return orderedVector;
    }
    

    public JassTrick playCardToTrick(JassCard card){
    	trick.playCard(card);
    	return trick;
    }
    
    public void resetTrick(){
    	trick.clear();
    }

	public JassTrick getTrick() {
		return this.trick;
	}
    
}

