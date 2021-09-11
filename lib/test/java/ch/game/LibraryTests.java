package ch.game;

import ch.game.cardgame.TestCardGameFactory;
import ch.game.jass.TestHand;
import ch.game.jass.TestJass;
import ch.game.jass.TestJassCard;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({	TestJass.class,
        TestCardGameFactory.class,
        TestJassCard.class,
        TestHand.class})
public class LibraryTests {
}
