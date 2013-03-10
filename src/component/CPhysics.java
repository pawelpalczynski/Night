package component;

import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class CPhysics extends Component {

	public CPhysics(String id){
		this.id = id;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		Vector2f velocity = owner.getVelocity();
		
		position.add(velocity.scale(delta));
		velocity.set(0, 0);
		
		owner.setPosition(position);
		owner.setVelocity(velocity);
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
}
