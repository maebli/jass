package ch.game.jass.impartial;

import ch.game.jass.Jass;
import ch.game.jass.JassCard;
import ch.game.jass.JassDeck;
import ch.game.jass.JassTable;
import ch.game.jass.player.JassMove;
import ch.game.jass.player.JassPlayer;

import java.util.logging.Logger;


public class JassGameModerator{
	
	private static final Logger LOGGER = Logger.getLogger("Logger");
	
	private JassPlayer nextPlayer;
	
	private JassMove nextMove=new JassMove();
	
	private static final JassCard startingCard=
			new JassCard(JassCard.Suit.EICHEL.ordinal()
					,JassCard.Rank.BANNER.ordinal());


	private JassScoreKeeper scoreKeeper;


	public void registerScoreKeeper(JassScoreKeeper keeper){
		scoreKeeper = keeper;
	}

	public void dealHands(JassTable table) {

		JassDeck deck= new JassDeck();
		deck.shuffle();
		
		int i=0;
		
		while(deck.isNotEmpty()){
			for(JassPlayer player:table.getPlayers()){
				i++;
				JassCard card=deck.removeTopCard();
				card.setTable(table);
				player.dealCard(card);
				LOGGER.info("dealing card "+i+" "+card);
				if(card.equals(startingCard)){
					nextPlayer=player;
				}
			}
		}
		
		LOGGER.info("Starting player ="+nextPlayer);
		
	}

	public void letPlayerChooseGameMode(JassTable table){
		if(nextPlayer.decidedToChooseGameMode()) {
			table.setGameMode( nextPlayer.chooseGameMode());
		}else{
			if(Jass.isVerbose()) {
				System.out.println(nextPlayer + " chooses to let his partner choose the game mode ");
			}
			nextPlayer=table.getPlayers().get((table.getPlayers().indexOf(nextPlayer)+2)%3);
			table.setGameMode(nextPlayer.chooseGameMode());
		}
		if(Jass.isVerbose()) {
			System.out.println(nextPlayer + " chooses mode " + JassTable.getGameModeAsString(table.getGameMode()));
		}
	}


	public void moderateRound(JassTable table) {
		
		LOGGER.info("Game Mode = "+table.getGameMode());
		
		for(JassPlayer player:table.getPlayers(nextPlayer)){
			
			JassCard card=player.playCard(table.getTrick());
			
			nextMove.setCard(card);
			nextMove.setPlayer(player);
			nextMove.setTrick(table.getTrick());
			
			if(JassUmpire.abidesByTheRules(nextMove,table.getGameMode())){
				table.playCardToTrick(card,nextPlayer);
				if(Jass.isVerbose()) {
					System.out.println(player + " played " + card + " to trick.");
				}
			}else{
				System.err.println("Player "+player+"played"+
						"illegal card to trick ");
				System.exit(0);
			}
		}
		
		nextPlayer=JassUmpire.determineWinner(table,this,table.getGameMode());
		scoreKeeper.addToPile(nextPlayer,table.getTrick());
		
		table.resetTrick();
		
	}
	
	public JassPlayer getCurrentStartPlayer(){
		return nextPlayer;
	}







	
}
