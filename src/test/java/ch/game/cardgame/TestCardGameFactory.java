package ch.game.cardgame;

import ch.game.jass.exception.JassCardGameDoesNotExistException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class TestCardGameFactory {

	
	@Test(expected=JassCardGameDoesNotExistException.class)
	public void TestCreatingOfNonExistantCardGame() throws JassCardGameDoesNotExistException{
		CardGameFactory.make("Im not a Game Name.");
	}
	
	@Test
	public void testCreationFoExistantCardGame() throws JassCardGameDoesNotExistException{
		CardGame jass=CardGameFactory.make("Jass");
		assertThat(jass,instanceOf(CardGame.class));
	}
}
