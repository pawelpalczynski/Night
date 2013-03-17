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

import entity.EntityContainer;

public class CJBox2D extends Component {
	
	CColidable colidable = new CColidable();
	
	public static int RECTANGLE = 0;
	public static int CIRCLE = 1;
	Body body;
	BodyDef bodyDef;
	FixtureDef fixtureDef;
	Shape boxShape;
	int shape;
	float width = 1f;
	float height = 1f;
	int filter_group;
	int filter_mask;
	int filter_category;
	float restitution;
	
	public CJBox2D(){
		this(0, 0, BodyType.STATIC, RECTANGLE, 0);
	}
	
	public CJBox2D(float x, float y, BodyType type, int shape, int filter_group){
		this(x, y, type, shape, filter_group, 1, 1);
	}
	
	public CJBox2D(float x, float y, BodyType type, int shape, int filter_group, int filter_mask, int filter_category){
		this(x, y, type, shape, filter_group, 1, 1, 0);
	}
	
	public CJBox2D(float x, float y, BodyType type, int shape, int filter_group, int filter_mask, int filter_category, float restitution){
		this.id = "JBox2D";
		this.shape = shape;
		this.bodyDef = new BodyDef();
		this.bodyDef.type = type;
		this.bodyDef.position.set(x*EntityContainer.SlickToJBox2D, y*EntityContainer.SlickToJBox2D);
		this.body = EntityContainer.getWorld().createBody(bodyDef);
		this.filter_group = filter_group;
		this.filter_mask = filter_mask;
		this.filter_category = filter_category;
		this.restitution = restitution;
		
		fixtureDef = new FixtureDef();
		fixtureDef.density = 1f;
		
		this.body.setUserData(colidable);
	}
	
	public void setPosition(){
		owner.getPosition().x = body.getPosition().x*EntityContainer.JBox2DToSlick - owner.getWidth()/2f;
		owner.getPosition().y = body.getPosition().y*EntityContainer.JBox2DToSlick - owner.getHeight()/2f;
	}
	
	public void setDimensions() {
		// Setting the shape for collisions
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
		
		// Setting collision filtering
		Filter filter = new Filter();
		filter.groupIndex = filter_group;
		filter.categoryBits = filter_category;
		filter.maskBits = filter_mask;
		fixtureDef.filter = filter;
		
		fixtureDef.restitution = restitution;
		
		body.createFixture(fixtureDef);
		
	}

	@Override
	public void setDependencies() {
		if (owner.getComponent("Colidable") != null) {
			colidable = (CColidable) owner.getComponent("Colidable");
			this.body.setUserData(colidable);
		}
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded") {
			if (message.getSource().getId() == "Colidable") {
				colidable = (CColidable) message.getSource();
				this.body.setUserData(colidable);
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

	public BodyDef getBodyDef() {
		return bodyDef;
	}

	public Shape getBoxShape() {
		return boxShape;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public CColidable getColidable() {
		return colidable;
	}

}
