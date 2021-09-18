package ch.game.jass.rules;

import ch.game.jass.JassCard;
import ch.game.jass.JassTable;
import ch.game.jass.impartial.JassGameModerator;
import ch.game.jass.player.JassHand;
import ch.game.jass.player.JassMove;
import ch.game.jass.player.JassPlayer;

public class CorrectSuitMustBePlayedRule implements JassRule {

    @Override
    public boolean followsRule(JassMove move, JassTable.GameMode mode) {

        if (move.getTrick().isEmtpy()) {
            return true;
        }


        JassPlayer player = move.getPlayer();
        JassCard card = move.getCard();
        JassHand hand = player.getHand();

        int suitOfTrick = move.getSuitOfTrick();

        if(!player.canPlaySuit(suitOfTrick)) return true;

        if (JassTable.isTrumpfGame(mode)) {

            if(move.getCard().getSuit() == suitOfTrick) return true;

            int suitOfTrump = JassTable.getTrumpfSuit(mode);

            if(move.getCard().getSuit()== suitOfTrump) return true;

            JassCard bestTrump = new JassCard(suitOfTrump, JassCard.Rank.UNTER.ordinal());
            int numberOfTrumps = (int) hand.stream().filter(c -> c.getRank() == suitOfTrick).count();

            if(suitOfTrick == suitOfTrump){
                if(numberOfTrumps == 0){
                    return true;
                }else if (numberOfTrumps == 1){
                    if(hand.containsCard(bestTrump)){
                        return true;
                    };
                }else{
                    return (card.getSuit() == suitOfTrump);
                }
            }
        }

        if (player.canPlaySuit(suitOfTrick)) {
            return card.getSuit() == suitOfTrick;
        } else {
            return true;
        }
    }

}
