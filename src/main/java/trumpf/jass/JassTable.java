package trumpf.jass;


import java.util.Vector;

import trumpf.cardgame.Player;
import trumpf.cardgame.Table;

public class JassTable implements Table{
	
    private Vector<Player> players; 
    
    /*
     * Sitting arrangement
     * 
     *  (0)		(3)
     *     TABLE
     *  (1)		(2)
     *  
     *  team a: 0,2
     *  team b: 1,3
     */
    
    public JassTable(Vector<Player> players){
    	if(players.size()!=4) {
    		System.exit(0);
    	}
    	this.players=players;
    }
    
    public Vector<Player> getPlayers(){
    	return players;
    }
    
    public Vector<Player> getPlayers(Player firstPlayer){
    	
    	int index=players.indexOf(firstPlayer);
    	Vector<Player> orderedVector=new Vector<Player>();
    	
    	for(int i=0;i<players.size();i++){
    		orderedVector.add(players.elementAt(index));
    		index=(index+1)%players.size();
    	}

    	return orderedVector;
    }
}

