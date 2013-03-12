package component.AI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class CChaseAI extends CAI {
	
	Vector2f direction = new Vector2f();
	Vector2f center;
	float speed = 0.1f;
	
	public CChaseAI(){
		this.id = "AIChase";
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta){
		center = owner.getCenter();
		velocity = physics.getVelocity();
		direction.set(player.getPosition().x - center.x, player.getPosition().y - center.y);
		
		owner.setRotation((float) direction.getTheta() + 180);
		
		velocity.set(1f, 1f);
		velocity.setTheta(direction.getTheta());
		velocity.scale(speed);
	}
}
