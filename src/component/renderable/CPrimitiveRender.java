package component.renderable;

import message.CMessage;
import message.Message;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class CPrimitiveRender extends CRenderable {

	String primitive;
	float size = 5f;
	
	public CPrimitiveRender() {
		this.id = "PrimitieRender";
		this.primitive = "Circle";
	}
	
	public CPrimitiveRender(String primitive) {
		this.id = "PrimitieRender";
		this.primitive = primitive;
	}
	
	public CPrimitiveRender(String primitive, float size) {
		this.id = "PrimitieRender";
		this.primitive = primitive;
		this.size = size;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if (primitive == "Circle"){
			gr.setColor(Color.white);
			gr.fillOval(owner.getPosition().getX(), owner.getPosition().getY(), size, size);
		} else if (primitive == "Square"){
			gr.setColor(Color.white);
			gr.fillRect(owner.getPosition().getX(), owner.getPosition().getY(), size, size);
		} else if (primitive == "Quad"){
			gr.setColor(Color.white);
			gr.fillRect(owner.getPosition().getX(), owner.getPosition().getY(), size, size);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDimensions() {
		// TODO Auto-generated method stub
		
	}


}
