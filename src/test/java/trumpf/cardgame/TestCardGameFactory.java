package trumpf.cardgame;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import trumpf.cardgame.exception.CardGameDoesNotExistException;

public class TestCardGameFactory {

	
	@Test(expected=CardGameDoesNotExistException.class)
	public void TestCreatinOfNonExistantCardGame() throws CardGameDoesNotExistException{
		CardGameFactory.make("Im not a Game Name.");		
	}
	
	@Test
	public void testCreationFoExistantCardGame() throws CardGameDoesNotExistException{
		CardGame jass=CardGameFactory.make("Jass");
		assertThat(jass,instanceOf(CardGame.class));
	}
}
