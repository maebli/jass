package trumpf.jass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import trumpf.cardgame.Player;
import trumpf.cardgame.Table;
import trumpf.cardgame.Team;
import trumpf.jass.JassTablePosition;

public class JassTable implements Table{
    private Map<JassTablePosition,Player> table = new TreeMap<JassTablePosition,Player>(); 
    
    
    //Collection<JassTablePosition> positions = new ArrayList<JassTablePosition>();
    private JassTablePosition pos1A = new JassTablePosition();
    private JassTablePosition pos2B = new JassTablePosition();
    private JassTablePosition pos3A = new JassTablePosition();
    private JassTablePosition pos4B = new JassTablePosition();
    
    public JassTable(Map<Player,Team> player_team){
        //TODO: iterate over players and put them to the table that the players
        //of pos1A nad pos3A are used by one team and pos2B and pos4B by the other
        //team.
    }
}
