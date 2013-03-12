package component.AI;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import component.CPhysics;
import component.Component;
import entity.EntityContainer;
import entity.Player;

public abstract class CAI extends Component {
	
	Vector2f velocity;
	Player player;
	CPhysics physics;
	
	@Override
	public void setDependencies() {
		this.player = EntityContainer.getPlayer();
		this.physics = (CPhysics) owner.getComponent("Physics");
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded"){
			if (message.getSource().getId() == "Physics"){
				physics = (CPhysics) message.getSource();
			}
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {

	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
}
