package ch.game.jass.rules;

import ch.game.jass.JassTable;
import ch.game.jass.player.JassMove;

public interface JassRule {

	boolean followsRule(JassMove move, JassTable.GameMode mode);

}
