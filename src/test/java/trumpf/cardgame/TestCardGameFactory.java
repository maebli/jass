package trumpf.cardgame;

import org.junit.Test;
import trumpf.jass.exception.JassCardGameDoesNotExistException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class TestCardGameFactory {

	
	@Test(expected=JassCardGameDoesNotExistException.class)
	public void TestCreatinOfNonExistantCardGame() throws JassCardGameDoesNotExistException{
		trumpf.cardgame.CardGameFactory.make("Im not a Game Name.");
	}
	
	@Test
	public void testCreationFoExistantCardGame() throws JassCardGameDoesNotExistException{
		CardGame jass=CardGameFactory.make("Jass");
		assertThat(jass,instanceOf(CardGame.class));
	}
}
