package component.renderable;

import message.CMessage;
import message.Message;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class CPrimitiveRender extends CRenderable {
	
	public static final int CIRCLE = 1;
	public static final int SQUARE = 2;
	public static final int RECTANGLE = 3;

	int primitive;
	float size = 5f;
	float width = 5f;
	float height = 5f;
	float x = 0;
	float y = 0;
	Color color = Color.white;
	
	public CPrimitiveRender() {
		this.id = "PrimitiveRender";
		this.primitive = CIRCLE;
	}
	
	public CPrimitiveRender(int primitive) {
		this.id = "PrimitiveRender";
		this.primitive = primitive;
	}
	
	public CPrimitiveRender(int primitive, float size) {
		this.id = "PrimitiveRender";
		this.primitive = primitive;
		this.size = size;
		this.width = size;
		this.height = size;
	}
	
	public CPrimitiveRender(int primitive, float width, float height){
		this.id = "PrimitiveRender";
		this.primitive = primitive;
		this.size = width > height ? width : height;
		this.width = width;
		this.height = height;
	}
	
	public CPrimitiveRender(int primitive, float width, float height, float x, float y){
		this.id = "PrimitiveRender";
		this.primitive = primitive;
		this.size = width > height ? width : height;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public CPrimitiveRender(int primitive, float width, float height, float x, float y, Color color){
		this.id = "PrimitiveRender";
		this.primitive = primitive;
		this.size = width > height ? width : height;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if (primitive == 1){
			gr.setColor(Color.white);
			gr.fillOval(owner.getPosition().getX() + x, owner.getPosition().getY() + y, size, size);
		} else if (primitive == 2){
			gr.setColor(Color.white);
			gr.fillRect(owner.getPosition().getX() + x, owner.getPosition().getY() + y, size, size);
		} else if (primitive == 3){
			gr.setColor(Color.white);
			gr.fillRect(owner.getPosition().getX() + x, owner.getPosition().getY() + y, width, height);
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
