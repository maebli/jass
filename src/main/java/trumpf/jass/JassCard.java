package trumpf.jass;

import trumpf.cardgame.Card;

public class JassCard implements Card{
	
    private int color;
    private int name;
    
    public enum color {
        EICHEL,
        ROSEN,
        SCHELLEN,
        SCHILTEN
    }
    
    public enum name {
        C6,
        C7,
        C8,
        C9,
        BANNER,
        UNTER,
        OBER,
        KOENIG,
        ASS
    }
    
    public JassCard(int name, int color){
        this.color = color;
        this.name = name;
    }
    
    @Override
	public int getColor() {
		return this.color;
	}
    
    @Override
	public int getName() {
		return this.color;
	}
    
    @Override
	public void setColor(int color) {
		this.color = color;
	}    
        
   @Override
	public void setName(int name) {
		this.name = name;
	}  
}
