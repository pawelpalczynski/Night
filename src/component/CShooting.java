package component;

import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.Bullet;
import entity.EntityContainer;

public class CShooting extends Component {
	
	public CShooting( String id ) {
        this.id = id;
    }

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_SPACE)){
			Bullet bullet = new Bullet("bullet", 1f, owner.getRotation());
			bullet.setPosition(new Vector2f(owner.getPosition().getX(), owner.getPosition().getY()));
			EntityContainer.addEntity(bullet);
		}
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}