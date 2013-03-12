package component.renderable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import component.Component;
 
public abstract class CRenderable extends Component {
	
	int priority = 0;
	
	public abstract void setDimensions();
     
    public abstract void render(GameContainer gc, StateBasedGame sb, Graphics gr);

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}