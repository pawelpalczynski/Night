package entity.enemy;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import component.Component;
import component.AI.CAI;
import component.AI.CChaseAI;
import component.AI.CIdleAI;

import entity.Entity;

public class Enemy extends Entity {
	
	public Enemy(){
		addComponent(new CIdleAI());
	}
	
	public void changeAI(String AI){
//		Component component = getAI();
//		if (AI == "Chase"){
//			component = new CChaseAI();
//		}
	}
	
	public Component getAI() {    
        for(Component comp : getComponentList()) {
        	if (comp instanceof CAI)
        		return comp;
        }
        return null;
    }
	
	public void update(GameContainer gc, StateBasedGame sb, int delta){
		super.update(gc, sb, delta);
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_1)){
			changeAI("Idle");
		} else if (input.isKeyPressed(Input.KEY_2)){
			changeAI("Chase");
		}
	}
	
}
