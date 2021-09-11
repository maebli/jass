package ch.game.jass.rules;

import ch.game.jass.player.JassMove;

public interface JassRule {

	boolean followsRule(JassMove move);

}
