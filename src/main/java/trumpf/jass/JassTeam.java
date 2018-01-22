package trumpf.jass;

import trumpf.cardgame.Team;

public class JassTeam implements Team {

	private static boolean isTeamA=false;
	
	public JassTeam(boolean isTeamA){
		this.isTeamA=isTeamA;
	}
	boolean isTeamA() {
		return isTeamA;
	}
}
