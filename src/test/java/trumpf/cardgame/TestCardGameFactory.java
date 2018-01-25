package trumpf.cardgame;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import trumpf.jass.exception.JassCardGameDoesNotExistException;

public class TestCardGameFactory {

	
	@Test(expected=JassCardGameDoesNotExistException.class)
	public void TestCreatinOfNonExistantCardGame() throws JassCardGameDoesNotExistException{
		CardGameFactory.make("Im not a Game Name.");		
	}
	
	@Test
	public void testCreationFoExistantCardGame() throws JassCardGameDoesNotExistException{
		CardGame jass=CardGameFactory.make("Jass");
		assertThat(jass,instanceOf(CardGame.class));
	}
}
