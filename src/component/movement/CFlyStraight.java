package component.movement;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import component.Component;

public class CFlyStraight extends Component{
	
	private float direction;
	private float speed;
	
	/**
	 * 
	 * @param id
	 * @param direction Angle in degrees
	 * @param speed
	 */
	
	public CFlyStraight(float direction, float speed){
		this.id = "FlyStraight";
		this.direction = direction;
		this.speed = speed;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		
		position.x += this.speed*delta*Math.sin(Math.toRadians(this.direction));
		position.y -= this.speed*delta*Math.cos(Math.toRadians(this.direction));
		
		owner.setPosition(position);
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