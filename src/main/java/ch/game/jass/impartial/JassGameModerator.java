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
	
	private static JassPlayer nextPlayer;
	
	private static JassMove nextMove=new JassMove();
	
	private static final JassCard startingCard=
			new JassCard(JassCard.Suit.EICHEL.ordinal()
					,JassCard.Rank.BANNER.ordinal());
    
    private static Jass.GameMode gameMode;

	public static void dealHands(JassTable table) {
		
		JassDeck deck= new JassDeck();
		deck.shuffle();
		
		int i=0;
		
		while(deck.isNotEmpty()){
			for(JassPlayer player:table.getPlayers()){
				i++;
				JassCard card=deck.removeTopCard();
				player.dealCard(card);
				LOGGER.info("dealing card "+i+" "+card);
				if(card.equals(startingCard)){
					nextPlayer=player;
				}
			}
		}
		
		LOGGER.info("Starting player ="+nextPlayer);
		
	}

	public static void letPlayerChooseGameMode(JassTable table){
		if(nextPlayer.decidedToChooseGameMode()) {
			gameMode = nextPlayer.chooseGameMode();
			System.out.println(nextPlayer + " chooses mode " + Jass.getGameModeAsString(gameMode));
		}else{
			System.out.println(nextPlayer + " chooses to let his partner choose the game mode ");
		}
		nextPlayer=table.getPlayers().get((table.getPlayers().indexOf(nextPlayer)+2)%3);
		gameMode = nextPlayer.chooseGameMode();

		System.out.println(nextPlayer + " chooses mode " + Jass.getGameModeAsString(gameMode));
	}

	public static void setGameMode(Jass.GameMode mode) {
		gameMode = mode;
	}

	public static void moderateRound(JassTable table) {
		
		LOGGER.info("Game Mode = "+getGameMode());
		
		for(JassPlayer player:table.getPlayers(nextPlayer)){
			
			JassCard card=player.playCard(table.getTrick());
			
			nextMove.setCard(card);
			nextMove.setPlayer(player);
			nextMove.setTrick(table.getTrick());
			
			if(JassUmpire.abidesByTheRules(nextMove)){
				table.playCardToTrick(card);
				System.out.println(player+" played "+card+" to trick.");
			}else{
				System.err.println("Player "+player+"played"+
						"illegal card to trick ");
				System.exit(0);
			}
		}
		
		nextPlayer=JassUmpire.determineWinner(table);
		JassScoreKeeper.addToPile(nextPlayer,table.getTrick());
		
		table.resetTrick();
		
	}
	
	public static JassPlayer getCurrentStartPlayer(){
		return nextPlayer;
	}
	
    public static Jass.GameMode getGameMode() {
		return gameMode;
	}
    
    public static boolean isTrumpfGame(){
    	return (gameMode!=Jass.GameMode.OBEN) &&
    			(gameMode !=Jass.GameMode.UNTEN);
    }

    public static int getTrumpfSuit(){
		if(isTrumpfGame()) {
			if(gameMode == Jass.GameMode.ROSE_TRUMPF) {
				return JassCard.Suit.ROSEN.ordinal();
			}else if(gameMode == Jass.GameMode.SCHELLE_TRUMPF){
				return JassCard.Suit.SCHELLEN.ordinal();
			}else if(gameMode == Jass.GameMode.SCHILTEN_TRUMPF){
				return JassCard.Suit.SCHILTEN.ordinal();
			}else if(gameMode == Jass.GameMode.EICHEL_TRUMPF){
				return JassCard.Suit.EICHEL.ordinal();
			}
		}
		System.err.println(" Not a Trump game!!");
		System.exit(1);

		return -1;
	}





	
}
