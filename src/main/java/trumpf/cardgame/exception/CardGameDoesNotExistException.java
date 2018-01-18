package trumpf.cardgame.exception;

public class CardGameDoesNotExistException extends Exception {

	/*
	 * Enforce the construction with a message 
	 */
	
	@SuppressWarnings("unused")
	private CardGameDoesNotExistException(){};
	
	public CardGameDoesNotExistException(String name) {
		super("The Game with the name \""+name+"\"does not exist");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
