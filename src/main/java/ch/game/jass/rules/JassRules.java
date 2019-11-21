package ch.game.jass.rules;

import java.util.HashSet;
import java.util.Set;


public class JassRules {

	/*
	 *  "Farben"
	 *  
	 *  Only for OBEN / UNTEN games at the moment
	 *  
	 */
	
	private static Set<JassRule> jassRules=new HashSet<JassRule>();
	
	static{
		jassRules.add(new CorrectSuitMustBePlayed());
	}
	
	public static Set<JassRule> getRules(){
		return jassRules;
	}


}
