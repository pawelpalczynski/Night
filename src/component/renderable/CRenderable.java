package component.renderable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import component.Component;
 
public abstract class CRenderable extends Component {
     
    public CRenderable(String id)
    {
    this.id = id;
    }
     
    public abstract void render(GameContainer gc, StateBasedGame sb, Graphics gr);
}