package component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class FlyStraightComponent extends Component{
	
	private float direction;
	private float speed;
	
	/**
	 * 
	 * @param id
	 * @param direction Angle in degrees
	 * @param speed
	 */
	
	public FlyStraightComponent(String id, float direction, float speed){
		this.id = id;
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

}
