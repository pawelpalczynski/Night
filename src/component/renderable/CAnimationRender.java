package component.renderable;

import message.CMessage;
import message.Message;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import component.CJBox2D;

public class CAnimationRender extends CRenderable {
	
	Animation animation;
	private SpriteSheet sheet;
	int width;
	int height;
	int timing;
	float inital_rotation;
	
	CJBox2D jbox;
	
	public CAnimationRender(String path, int width, int height, int spacing, int timing, float initial_rotation) throws SlickException{
		this.id = "AnimationRender";
		this.sheet = new SpriteSheet(path, width, height, spacing);
		this.animation = new Animation(this.sheet, timing);
		this.animation.setPingPong(true);
		this.animation.setAutoUpdate(false);
		this.width = width;
		this.height = height;
		this.timing = timing;
		this.inital_rotation = initial_rotation;
	}

	@Override
	public void setDimensions() {
		owner.setWidth(this.width);
		owner.setHeight(this.height);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		if (jbox.getBody().getLinearVelocity().lengthSquared() != 0){
			animation.start();
		} else {
			animation.stop();
		}
		
		animation.getCurrentFrame().rotate(owner.getRotation() - animation.getCurrentFrame().getRotation() + this.inital_rotation);
		animation.draw(owner.getPosition().x, owner.getPosition().y);
	}

	@Override
	public void setDependencies() {
		this.jbox = (CJBox2D) owner.getComponent("JBox2D");
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded"){
			if (message.getSource().getId() == "JBox2D"){
				this.jbox = (CJBox2D) message.getSource();
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		//animation.getCurrentFrame().rotate(owner.getRotation() - animation.getCurrentFrame().getRotation() - 90);
		animation.update(delta);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
