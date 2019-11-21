package jass.jass;


import jass.jass.players.JassPlayer;

public class JassMove {

	private JassPlayer player;
	private JassCard card;
	private JassTrick trick;
	
	
	public JassPlayer getPlayer() {
		return player;
	}
	
	public void setPlayer(JassPlayer player) {
		this.player = player;
	}

	public JassCard getCard() {
		return card;
	}
	
	public void setCard(JassCard card) {
		this.card = card;
	}
	
	
	public JassHand getPlayersHand(){
		return player.getHand();
	}
	
	public void setTrick(JassTrick trick){
		this.trick=trick;
	}
	
	public int getSuitOfTrick(){
		return this.trick.getSuit();
	}
	
	public JassTrick getTrick(){
		return this.trick;
	}
	
	

}
