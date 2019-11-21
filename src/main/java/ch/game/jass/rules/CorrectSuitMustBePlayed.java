package ch.game.jass.rules;

import ch.game.jass.JassCard;
import ch.game.jass.impartial.JassGameModerator;
import ch.game.jass.player.JassMove;
import ch.game.jass.player.JassPlayer;

public class CorrectSuitMustBePlayed implements JassRule {

    @Override
    public boolean abeidsByTheRule(JassMove move) {

        if (move.getTrick().isEmtpy()) {
            return true;
        }

        if (JassGameModerator.isTrumpfGame()) {
            System.err.println("Trumpf not implemented yet.");
            System.exit(0);
        }

        JassPlayer player = move.getPlayer();
        JassCard card = move.getCard();
        int suitOfTrick = move.getSuitOfTrick();

        if (player.canPlaySuit(suitOfTrick)) {
            return card.getSuit() == suitOfTrick;
        } else {
            return true;
        }
    }

}
