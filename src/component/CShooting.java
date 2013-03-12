package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.Bullet;
import entity.EntityContainer;

public class CShooting extends Component {
	
	public CShooting() {
        this.id = "Shooting";
    }

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Input input = gc.getInput();
		
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			Bullet bullet = new Bullet("bullet", 1f, owner.getRotation());
			bullet.setPosition(new Vector2f((float) (owner.getCenter().x + 2*owner.getWidth() * Math.sin(Math.toRadians(owner.getRotation()))), (float) (owner.getCenter().y - 2*owner.getHeight() * Math.cos(Math.toRadians(owner.getRotation())))));
			EntityContainer.addEntity(bullet);
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