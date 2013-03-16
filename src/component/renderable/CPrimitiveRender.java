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

	int primitive = CIRCLE;;
	float size = 5f;
	float width = 5f;
	float height = 5f;
	float x = 0;
	float y = 0;
	Color color = Color.white;
	boolean useEntityDimensions = false;
	
	public CPrimitiveRender() {
		this.id = "PrimitiveRender";
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
	
	public CPrimitiveRender(boolean useEntityDimensions, int shape) {
		this.id = "PrimitiveRender";
		this.primitive = shape;
		this.useEntityDimensions = useEntityDimensions;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if (useEntityDimensions) {
			if (primitive == 1){
				gr.setColor(this.color);
				gr.fillOval(owner.getPosition().x, owner.getPosition().y, owner.getWidth(), owner.getHeight());
			} else if (primitive == 2){
				gr.setColor(this.color);
				gr.fillRect(owner.getPosition().x, owner.getPosition().y, owner.getWidth(), owner.getWidth());
			} else if (primitive == 3){
				gr.setColor(this.color);
				System.out.println(owner.getPosition().x + " " + owner.getPosition().y + " " + owner.getWidth() + " " + owner.getHeight());
				gr.fillRect(owner.getPosition().x, owner.getPosition().y, owner.getWidth(), owner.getHeight());
			}
		} else {
			if (primitive == 1){
				gr.setColor(this.color);
				gr.fillOval(owner.getPosition().x + x, owner.getPosition().y + y, size, size);
			} else if (primitive == 2){
				gr.setColor(this.color);
				gr.fillRect(owner.getPosition().x + x, owner.getPosition().y + y, size, size);
			} else if (primitive == 3){
				gr.setColor(this.color);
				gr.fillRect(owner.getPosition().x + x, owner.getPosition().y + y, width, height);
			}
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
