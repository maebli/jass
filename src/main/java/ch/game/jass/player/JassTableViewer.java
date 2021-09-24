package ch.game.jass.player;

import ch.game.jass.JassCard;

public interface JassTableViewer {

    void reactToNewCardInTrick(final JassCard card, final Player player);
    void reactToEndOfGame();
}
