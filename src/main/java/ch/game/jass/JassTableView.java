package ch.game.jass;

import ch.game.jass.player.JassTableViewer;

public interface JassTableView {
    JassTable.GameMode getGameMode();
    void subScribeToTableEvents(JassTableViewer viewer);
    JassTrick getCurrentTrick();
}
