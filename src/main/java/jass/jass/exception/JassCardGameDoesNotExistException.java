package jass.jass.exception;

public class JassCardGameDoesNotExistException extends Exception {

	/*
	 * Enforce the construction with a message 
	 */
	
	@SuppressWarnings("unused")
	private JassCardGameDoesNotExistException(){};
	
	public JassCardGameDoesNotExistException(String name) {
		super("The Game with the name \""+name+"\"does not exist");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
