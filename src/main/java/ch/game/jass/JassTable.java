package ch.game.jass;


import ch.game.cardgame.TableView;
import ch.game.jass.player.JassPlayer;

import java.util.ArrayList;


public class JassTable implements TableView {

	private JassTable.GameMode gameMode;
	public enum GameMode{
		OBEN,
		UNTEN,
		SCHELLE_TRUMPF,
		SCHILTEN_TRUMPF,
		EICHEL_TRUMPF,
		ROSE_TRUMPF,
	}

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
		for(JassPlayer player :players){
			player.giveTableView(this);
		}
    	this.players=players;
    }

	public JassTable(){

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

	public static String  getGameModeAsString(GameMode mode){
		switch(mode){
			case OBEN:
				return "Oben";
			case UNTEN:
				return "Unten";
			case SCHELLE_TRUMPF:
				return "Schellen Trumpf";
			case SCHILTEN_TRUMPF:
				return "Schilten Trumpf";
			case EICHEL_TRUMPF:
				return "Eichel Trumpf";
			case ROSE_TRUMPF:
				return "Rosen Trumpf";
		}

		return "Unkown";
	}

	public void setGameMode(JassTable.GameMode mode) {
		gameMode = mode;
	}

	@Override
	public JassTable.GameMode getGameMode() {
		return gameMode;
	}

	public static boolean isTrumpfGame(JassTable.GameMode mode){
		return (mode!=JassTable.GameMode.OBEN) &&
				(mode !=JassTable.GameMode.UNTEN);
	}

	public static int getTrumpfSuit(JassTable.GameMode mode){
		if(isTrumpfGame(mode)) {
			if(mode == JassTable.GameMode.ROSE_TRUMPF) {
				return JassCard.Suit.ROSEN.ordinal();
			}else if(mode == JassTable.GameMode.SCHELLE_TRUMPF){
				return JassCard.Suit.SCHELLEN.ordinal();
			}else if(mode == JassTable.GameMode.SCHILTEN_TRUMPF){
				return JassCard.Suit.SCHILTEN.ordinal();
			}else if(mode == JassTable.GameMode.EICHEL_TRUMPF){
				return JassCard.Suit.EICHEL.ordinal();
			}
		}
		System.err.println(" Not a Trump game!!");
		System.exit(1);

		return -1;
	}
}

