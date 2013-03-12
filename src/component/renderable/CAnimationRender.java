package component.renderable;

import message.CMessage;
import message.Message;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class CAnimationRender extends CRenderable {
	
	Animation animation;
	private SpriteSheet sheet;
	
	public CAnimationRender(SpriteSheet sheet) throws SlickException{
		this.sheet = sheet;
		//this.animation = new Animation(this.sheet, 30);
	}

	@Override
	public void setDimensions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		//animation.start();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO Auto-generated method stub
		
	}

}
