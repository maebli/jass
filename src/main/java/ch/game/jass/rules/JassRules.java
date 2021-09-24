package ch.game.jass.rules;

import java.util.HashSet;
import java.util.Set;


public class JassRules {

	private static final Set<JassRule> jassRules=new HashSet<JassRule>();
	
	static{
		jassRules.add(new CorrectSuitMustBePlayedRule());
		jassRules.add(new UnderTrumpForbiddenRule());
	}
	
	public static Set<JassRule> getRules(){
		return jassRules;
	}


}
