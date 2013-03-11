package component;

import message.CMessage;
import message.MAddVelocity;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import component.movement.CMovement;

public class CPhysics extends Component {
	
	Vector2f velocity;
	
	CMovement movement;

	public CPhysics(){
		this.id = "Physics";
		this.velocity = new Vector2f(0, 0);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		
		position.add(velocity.scale(delta));
		velocity.set(0, 0);
	}

	@Override
	public void readMessage(Message message) {
		
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
	public void setVelocity(MAddVelocity message){
		this.velocity.add(message.getVelocity());
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded"){
			if (message.getSource().getId() == "TopDownMovement"){
				this.movement = (CMovement) message.getSource();
			}
		}
	}

	@Override
	public void setDependencies() {
		this.movement = (CMovement) owner.getComponent("TopDownMovement");
	}
}