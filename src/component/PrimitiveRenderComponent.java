package component;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class PrimitiveRenderComponent extends RenderComponent {

	String primitive; 
	
	public PrimitiveRenderComponent(String id) {
		super(id);
		this.primitive = "Circle";
	}
	
	public PrimitiveRenderComponent(String id, String primitive) {
		super(id);
		this.primitive = primitive;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if (primitive == "Circle"){
			gr.setColor(Color.white);
			gr.fillOval(owner.getPosition().getX(), owner.getPosition().getY(), 10, 10);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO Auto-generated method stub
		
	}


}
