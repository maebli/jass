package jass;

import jass.jass.TestDeck;
import jass.jass.TestHand;
import jass.jass.TestJassCard;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import jass.cardgame.TestCardGameFactory;
import jass.jass.TestJass;

@RunWith(Suite.class)
@SuiteClasses({	TestJass.class,
        TestCardGameFactory.class,
        TestJassCard.class,
        TestHand.class,
        TestDeck.class})
public class AllTests {
}
