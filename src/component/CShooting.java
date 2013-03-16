package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.Bullet;
import entity.EntityContainer;

public class CShooting extends Component {
	
	int weapon = 1;
	
	public CShooting() {
        this.id = "Shooting";
    }

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_1)) weapon = 1;
		if (input.isKeyPressed(Input.KEY_2)) weapon = 2;
		
		if (weapon == 1){
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
				Bullet bullet = new Bullet(1f, owner.getRotation());
				float wth = (float) (owner.getCenter().x + (1/2f) * owner.getWidth() * Math.sin(Math.toRadians(owner.getRotation()))) - bullet.getWidth()/2f;
				float hgt = (float) (owner.getCenter().y - (1/2f) * owner.getHeight() * Math.cos(Math.toRadians(owner.getRotation()))) - bullet.getHeight()/2f;
				bullet.setPosition(new Vector2f(wth, hgt));
				EntityContainer.addEntity(bullet);
			}
		} else {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				Bullet bullet = new Bullet(1f, owner.getRotation());
				float wth = (float) (owner.getCenter().x + (1/2f) * owner.getWidth() * Math.sin(Math.toRadians(owner.getRotation()))) - bullet.getWidth()/2f;
				float hgt = (float) (owner.getCenter().y - (1/2f) * owner.getHeight() * Math.cos(Math.toRadians(owner.getRotation()))) - bullet.getHeight()/2f;
				bullet.setPosition(new Vector2f(wth, hgt));
				EntityContainer.addEntity(bullet);
			}
		}
		
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

}