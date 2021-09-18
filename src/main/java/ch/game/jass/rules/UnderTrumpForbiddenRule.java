package ch.game.jass.rules;

import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.player.JassMove;

public class UnderTrumpForbiddenRule implements JassRule {
    @Override
    public boolean followsRule(JassMove move, JassTable.GameMode mode) {

        if(JassTable.isTrumpfGame(mode) == false) return true;

        if(move.getTrick().size()<=2) return true;

        JassCard firstCard = move.getTrick().get().get(0);
        JassCard winningCard = move.getTrick().getWinningCard(mode);
        int suitOfTrumpf = JassTable.getTrumpfSuit(mode);

        if(firstCard.getSuit()==suitOfTrumpf) return true;

        if(winningCard.getSuit() == suitOfTrumpf &&
                (winningCard.compareTo(move.getCard()) == -1)){
            return false;
        }

        return true;
    }
}
