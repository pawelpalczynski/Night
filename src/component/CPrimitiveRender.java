package component;

import message.Message;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class CPrimitiveRender extends CRenderable {

	String primitive;
	float size = 5f;
	
	public CPrimitiveRender(String id) {
		super(id);
		this.primitive = "Circle";
	}
	
	public CPrimitiveRender(String id, String primitive) {
		super(id);
		this.primitive = primitive;
	}
	
	public CPrimitiveRender(String id, String primitive, float size) {
		super(id);
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


}
