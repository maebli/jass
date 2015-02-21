package trumpf;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import trumpf.cardgame.TestCardGameFactory;
import trumpf.jass.TestJass;

@RunWith(Suite.class)
@SuiteClasses({	TestJass.class, TestCardGameFactory.class})
public class AllTests {
}
