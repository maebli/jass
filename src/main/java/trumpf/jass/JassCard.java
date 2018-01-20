package trumpf.jass;

import trumpf.cardgame.Card;

public class JassCard implements Card{
	
    private int color;
    private int name;
    private int value;
    
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
    
    public JassCard(int name, int color, int value){
        this.color = color;
        this.name = name;
        this.value = value;
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
	public int getValue() {
		return this.value;
	}
    
    @Override
	public void setColor(int color) {
		this.color = color;
	}    
        
   @Override
	public void setName(int name) {
		this.name = name;
	}  
        
    @Override
	public void setValue(int value) {
		this.value = value;
	}  
}
