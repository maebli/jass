package trumpf.jass;


import trumpf.cardgame.CardGame;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jass implements CardGame{
	
	private static final Logger LOGGER = Logger.getLogger(Jass.class.getName());

	private static final String GAME_NAME = "Jass";

    
    private JassTable table;
    
	public Jass(){
		LOGGER.log(Level.FINE, "New Jass game created.");
	}

	public void play() {
		
		JassGameModerator.dealHands(table);
		
		for(int i=0;i<JassHand.JASS_HAND_SIZE;i++){
			JassGameModerator.moderateRound(table);
		}
	}

	@Override
	public String getName() {
		return GAME_NAME;
	}


	@Override
	public void setPlayers(JassTable table) {
        this.table=table;
	}


	
	


}