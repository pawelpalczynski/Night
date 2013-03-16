package component;

import message.CMessage;
import message.Message;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import component.renderable.CAnimationRender;
import component.renderable.CRenderable;

import entity.EntityContainer;

public class CJBox2D extends Component {
	
	CRenderable renderable;
	
	public static int RECTANGLE = 0;
	public static int CIRCLE = 1;
	Body body;
	BodyDef bodyDef;
	FixtureDef fixtureDef;
	Shape boxShape;
	int shape;
	float width = 1f;
	float height = 1f;
	
	public CJBox2D(){
		this(0, 0, BodyType.STATIC, RECTANGLE);
	}
	
	public CJBox2D(float x, float y, BodyType type, int shape){
		this.id = "JBox2D";
		this.shape = shape;
		this.bodyDef = new BodyDef();
		this.bodyDef.type = type;
		this.bodyDef.position.set(x*EntityContainer.SlickToJBox2D, y*EntityContainer.SlickToJBox2D);
		this.body = EntityContainer.getWorld().createBody(bodyDef);
		
		fixtureDef = new FixtureDef();
		fixtureDef.density = 1f;
	}
	
	public void setPosition(){
		owner.getPosition().x = body.getPosition().x*EntityContainer.JBox2DToSlick - owner.getWidth()/2f;
		owner.getPosition().y = body.getPosition().y*EntityContainer.JBox2DToSlick - owner.getHeight()/2f;
	}
	
	public void setDimensions() {
		this.width = owner.getWidth()*EntityContainer.SlickToJBox2D;
		this.height = owner.getHeight()*EntityContainer.SlickToJBox2D;
		if (shape == 0){
			this.boxShape = new PolygonShape();
			((PolygonShape) boxShape).setAsBox(width/2f, height/2f);
		} else if (shape == 1){
			this.boxShape = new CircleShape();
			boxShape.m_radius = width > height ? width/2f : height/2f;
		}
		fixtureDef.shape = boxShape;
		body.createFixture(fixtureDef);
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "AddedComponent") {
			if (message.getSource().getId() == "AnimationRender") {
				renderable = (CAnimationRender) message.getSource();
				this.width = ((CAnimationRender)renderable).getWidth();
				this.height = ((CAnimationRender)renderable).getHeight();
				if (shape == RECTANGLE) ((PolygonShape) boxShape).setAsBox(width, height);
				else if (shape == CIRCLE) boxShape.m_radius = width > height ? width : height;
			}
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		setPosition();
	}

	public Body getBody() {
		return body;
	}

	public FixtureDef getFixtureDef() {
		return fixtureDef;
	}

	public void setFixtureDef(FixtureDef fixtureDef) {
		this.fixtureDef = fixtureDef;
	}

	public BodyDef getBodyDef() {
		return bodyDef;
	}

	public void setBodyDef(BodyDef bodyDef) {
		this.bodyDef = bodyDef;
	}

	public Shape getBoxShape() {
		return boxShape;
	}

	public void setBoxShape(Shape boxShape) {
		this.boxShape = boxShape;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
